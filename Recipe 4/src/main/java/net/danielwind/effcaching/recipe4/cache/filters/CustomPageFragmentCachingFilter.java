package net.danielwind.effcaching.recipe4.cache.filters;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.constructs.web.PageInfo;
import net.sf.ehcache.constructs.web.filter.PageFragmentCachingFilter;

import org.apache.log4j.Logger;

public class CustomPageFragmentCachingFilter extends PageFragmentCachingFilter {

	private static final Logger log = Logger.getLogger(CustomPageFragmentCachingFilter.class);
	public static final String FILTER_NAME = CustomPageFragmentCachingFilter.class.getSimpleName();

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
	 * The content length should not be set in the response, because it is a fragment of a page.
	 * 内容长度不应该在响应中设置，因为它是一个页面的片段。
	 */
	protected void writeResponse(final HttpServletResponse response, final PageInfo pageInfo) throws IOException {
        // Write the page
        final byte[] cachedPage = pageInfo.getUngzippedBody();
        //needed to support multilingual 需要支持多语言
        final String page = new String(cachedPage, response.getCharacterEncoding());
        //get vendor 获得供应商
        String implementationVendor = response.getClass().getPackage().getImplementationVendor();
        
        if (implementationVendor != null && implementationVendor.equals("\"Evermind\"")) {
            response.getOutputStream().print(page);
        } else {
        	log.info("--- Executing fragment action from Ehcache Filter (Cached) ---");
            response.getWriter().write(page);
        }
    }

}
