package net.danielwind.effcaching.recipe7.cache;

import java.util.List;

import net.danielwind.effcaching.recipe7.domain.Person;
import net.danielwind.effcaching.recipe7.listeners.CacheDelegateEventListener;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import org.apache.log4j.Logger;

public final class CacheDelegate {
	
	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	
	private static final String CACHE_NAME = "personCache";
	private static final String EHCACHE_CONFIG_LOCATION = "src/main/resources/ehcache.xml";
	
	private Cache cache;
	private CacheManager manager;
	
	/**
	 * Constructor -- Initialize Cache Layer (EhCache)
	 */
	public CacheDelegate() {
		log.debug("-------- Configuring EhCache Delegate Class ---------");
		manager = new CacheManager(EHCACHE_CONFIG_LOCATION);
		cache = manager.getCache(CACHE_NAME); 
		cache.setMemoryStoreEvictionPolicy(new RndPolicy());
		
		//register our custom event listener in Cache Manager
		cache.getCacheEventNotificationService().registerListener(new CacheDelegateEventListener());
		
		log.info("--- Eviction Policy set to: " + cache.getMemoryStoreEvictionPolicy().getName() + " ---");
	}
	
	/**
	 * Loads a Person list in Cache Layer 加载缓存层中的人员列表
	 * @param people: List of Multiple Person Objects 
	 */
	public void loadInCache(List<Person> people) {
		
		int personListSize = people.size();
		
		if(personListSize > 0){
			
			//proceed filling cache layer with all employees
			//继续填充所有员工的缓存层
			for(int i = 0; i < personListSize; i++){
				cache.put(new Element((i + 1), people.get(i)));
			}
		}	
	}
	
	/**
	 * Loads a single Person instance in cache
	 * 缓存中加载单个Person实例
	 * @param person
	 * 		  A Person Object	
	 */
	public void loadSingleItemInCache(Person person) {
		cache.put(new Element((cache.getSize() + 1), person));	
	}
	
	/**
	 * Method for getting the current Cache instance that is active
	 * 获取当前活动的Cache实例的方法
	 * @return EhCache Cache instance
	 */
	public Cache getCache() {
		
		return cache;
	}
	
	/**
	 * Clear cache layer (Simple removal, non-clustered)
	 * 清除缓存层（简单删除，非群集）
	 */
	public void emptyCache() {
		cache.removeAll();
	}
}
