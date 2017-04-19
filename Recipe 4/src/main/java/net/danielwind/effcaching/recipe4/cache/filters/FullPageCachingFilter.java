package net.danielwind.effcaching.recipe4.cache.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.PageInfo;
import net.sf.ehcache.constructs.web.ResponseHeadersNotModifiableException;
import net.sf.ehcache.constructs.web.ResponseUtil;
import net.sf.ehcache.constructs.web.filter.CachingFilter;

import org.apache.log4j.Logger;

public class FullPageCachingFilter extends CachingFilter {
	
	private static final Logger log = Logger.getLogger(FullPageCachingFilter.class);
	public static final String FILTER_NAME = FullPageCachingFilter.class.getSimpleName();
	
	protected String getCacheName() {
		return FILTER_NAME;
	}

	/**
	 * You can override this method and do your own key calculation. For example,
	 * you could create an specific URL parameter and read it here to determine caching.
	 * In this case, we are reading the entire URL + query strings.
	 * 你可以覆盖此方法并进行自己的密钥计算。 例如，
	 * 你可以创建一个特定的URL参数，并在此处阅读以确定缓存。 
	 * 在这种情况下，我们正在阅读整个URL +查询字符串。
	 */
	@Override
	protected String calculateKey(HttpServletRequest httpRequest) {

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append(httpRequest.getRequestURI()).append(httpRequest.getQueryString());
		String key = stringBuffer.toString();
		
		return key;
	}

	@Override
	protected CacheManager getCacheManager() {

		return CacheManager.getInstance();
	}
	
	/**
	 * Overriding this method's functionality to add simple logging.
	 * 覆盖此方法的功能以添加简单的日志记录。
	 */
	@Override
	protected void writeContent(final HttpServletRequest request,
								 final HttpServletResponse response,
								 final PageInfo pageInfo) throws IOException,
								                     	ResponseHeadersNotModifiableException{
		
		byte[] body;
		
		if (acceptsGzipEncoding(request)) {
			ResponseUtil.addGzipHeader(response);
			body = pageInfo.getGzippedBody();
			if (ResponseUtil.shouldGzippedBodyBeZero(body, request)) {
				body = new byte[0];
			}
		} else {
			body = pageInfo.getUngzippedBody();
		}

		boolean shouldBodyBeZero = ResponseUtil.shouldBodyBeZero(request, pageInfo.getStatusCode());
		
		if (shouldBodyBeZero) {
		     body = new byte[0];
		}

		log.info("--- Executing load action from EhCache Filter (Cached) ---");
		
        response.setContentLength(body.length);
        response.getOutputStream().write(body);
	}
}
