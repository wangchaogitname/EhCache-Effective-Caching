package net.danielwind.effcaching.recipe7.cache;

import org.apache.log4j.Logger;

import net.danielwind.effcaching.recipe7.utils.RNG;
import net.sf.ehcache.Element;
import net.sf.ehcache.store.AbstractPolicy;

public class RndPolicy extends AbstractPolicy {
	
	//Our custom cache eviction policy (Random Replacement Cache) 
	//我们的自定义缓存排除策略（随机替换缓存）
	public static final String NAME = "RND";
	private static final Logger log = Logger.getLogger(RndPolicy.class);
	
	@Override
	public String getName() {
		return NAME;
	}

	/**
	 * Read the elements cache metadata and compares both with our
	 * custom comparison algorithm. In this simple case, we are simply 
	 * using the creationTime metadata to determine element longevity.
	 * 读取元素缓存元数据并将其与我们的自定义比较算法进行比较。 
	 * 在这种简单的情况下，我们只是使用creationTime元数据来确定元素寿命。
	 * 
	 * Comparing in Ehcache works as described below:
	 * if returns true => second element is preferable for eviction
	 * if returns false => first element is preferable for eviction
	 * 比较在Ehcache中的工作，如下所述：
	 * 如果返回true =>第二元件是优选的驱逐
	 * 如果返回false =>第一元件是优选的驱逐
	 */
	@Override
	public boolean compare(Element element1, Element element2) {
		
		/**
		 * 50% chances of getting a false comparing 
		 * 得到一个错误的比较50个％几率 
		 */
		if(RNG.getValue() > 5){
			log.debug("--- Calculated random value generated in RND Policy: "+ false);
			return false;
		
		} else {
			log.debug("--- Calculating random value generated in RND Policy: "+ true);
			return true;
		}
	}

}
