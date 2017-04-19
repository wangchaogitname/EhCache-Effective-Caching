package net.danielwind.effcaching.recipe2.factory;

import java.util.Properties;

import net.danielwind.effcaching.recipe2.exceptions.CacheDelegateExceptionHandler;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandler;
import net.sf.ehcache.exceptionhandler.CacheExceptionHandlerFactory;

public class CacheDelegateExceptionHandlerFactory extends
		CacheExceptionHandlerFactory {

	public CacheDelegateExceptionHandlerFactory() {

	}

	@Override
	public CacheExceptionHandler createExceptionHandler(Properties properties) {
		/*** uncomment line if declarative configuration is used ***/
		/*** 如果使用声明式配置，则取消注释行***/
		//return CacheDelegateExceptionHandler.INSTANCE;
		return null;
	}

}
