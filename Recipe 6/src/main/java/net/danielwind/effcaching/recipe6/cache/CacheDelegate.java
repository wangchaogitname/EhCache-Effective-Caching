package net.danielwind.effcaching.recipe6.cache;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import net.danielwind.effcaching.recipe6.domain.Employee;
import net.danielwind.effcaching.recipe6.utils.Role;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.search.Attribute;
import net.sf.ehcache.search.Direction;
import net.sf.ehcache.search.Query;
import net.sf.ehcache.search.Result;
import net.sf.ehcache.search.Results;
import net.sf.ehcache.search.aggregator.Aggregators;

import org.apache.log4j.Logger;

public final class CacheDelegate {
	
	private static final Logger log = Logger.getLogger(CacheDelegate.class);
	
	private static final String CACHE_NAME = "employeeCache";
	private static final String EHCACHE_CONFIG_LOCATION = "src/main/resources/ehcache.xml";
	
	private HashMap<String, Attribute<?>> cacheAttributes;
	private CacheManager manager;
	private Cache cache; 
	
	/**
	 * Constructor -- Initialize Cache Layer (EhCache)
	 */
	public CacheDelegate() {
		 log.debug("-------- Configuring EhCache Delegate Class ---------");
		 manager = new CacheManager(EHCACHE_CONFIG_LOCATION);
		 cache = manager.getCache(CACHE_NAME);
	}
	
	/**
	 * Loads an Employee list in Cache Layer
	 * @param employees
	 */
	public void loadInCache(List<Employee> employees) {
		
		int employeeListSize = employees.size();
		
		log.debug("------ Employees Bulk Loading in EhCache Layer, number of employees found: " + employeeListSize + " ----------");
		
		if(employeeListSize > 0){
			
			//proceed filling cache layer with all employees
			for(int i = 0; i < employeeListSize; i++){
				cache.put(new Element((i + 1), employees.get(i)));
			}
			
			/**
			 * load the attributes (as defined in ehcache.xml)
			 * and store them in the reusable Cache Attributes Map
			 **/
			cacheAttributes = new HashMap<String, Attribute<?>>();
			
			cacheAttributes.put("lastname", cache.getSearchAttribute("lastname"));
			cacheAttributes.put("profile", cache.getSearchAttribute("profile"));
			cacheAttributes.put("department", cache.getSearchAttribute("department"));
			cacheAttributes.put("role", cache.getSearchAttribute("role"));
			cacheAttributes.put("salary", cache.getSearchAttribute("salary"));
			cacheAttributes.put("social", cache.getSearchAttribute("social"));
			
		}	
	}
	
	/**
	 * Clear cache layer (Simple removal, non-clustered)
	 */
	public void emptyCache() {
		cache.removeAll();
	}
	
	//-------------- EhCache search queries ---------------//
	
	/**
	 * Searches an Employee that comply with the social security number criteria.
	 * This is a simple example of a SELECT-like search query using a String parameter.
	 * 搜索与社会安全号码符合标准的员工。
	 * 这是使用一个字符串参数的SELECT状搜索查询的一个简单的例子。
	 * @param socialNumber
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Employee searchEmployeeBySocialNumber(String socialNumber) {
		
		Employee employee = null;
		
		//create EhCache Search API Query 创建的Ehcache搜索API查询
		Query query = cache.createQuery();
		query.includeKeys();
		query.includeValues();
		
		//cast attribute from HashMap
		Attribute<String> attribute = (Attribute<String>) cacheAttributes.get("social");
		
		//add query criteria like: 'select {key, value} from Employee where socialNumber = ${@param socialNumber}'
		query.addCriteria(attribute.eq(socialNumber));
		
		//get the results list and loop on them (only one result for this query)
		//获取对他们的结果列表和循环（此查询只有一个结果）
		Results results = query.execute();
		
		for(Result result : results.all()){
			/*
			log.info("Key: " + result.getKey());
			log.info("Value: " + result.getValue());
			log.info("Value Class: " + result.getValue().getClass());
			*/
			
			//employee found, cast it
			employee = (Employee) result.getValue();
			
			break;
		}
		
		return employee;
	}
	
	/**
	 * Searches a list of Employees that comply with the role criteria.
	 * This is a simple example of a SELECT-like search query but this 
	 * time using an Enumeration as search parameter. 
	 * 搜索符合角色标准的员工名单。 
	 * 这是一个类似SELECT的搜索查询的简单示例，但这次使用枚举作为搜索参数。
	 * @param role
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> searchEngineers() {
		
		log.info("Searching all employees whose role is: " + Role.ENGINEER);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		//create EhCache Search API Query
		Query query = cache.createQuery();
		
		//cast attribute from HashMap
		Attribute<Role> attribute = (Attribute<Role>) cacheAttributes.get("role");
		
		//add query criteria like: 'select {key, value} from Employee where role = ${@param role}'
		query.addCriteria(attribute.eq(Role.ENGINEER));
		
		//get the results list and loop on them
		Results results = query.execute();
		
		for(Result result : results.all()){
			/*
			log.info("Key: " + result.getKey());
			log.info("Value: " + result.getValue());
			log.info("Value Class: " + result.getValue().getClass());
			*/
			
			Employee employee = (Employee) result.getValue();
			employees.add(employee);
		}
		
		return employees;
	}
	
	/**
	 * Searches a list of Employees that comply with the salary condition criteria.
	 * This example shows how to do conditional operations (>, <, =) on queries as
	 * well as how to sort by descending order. 
	 * 搜索符合薪资条件标准的员工名单。 
	 * 此示例显示如何对查询执行条件操作（>，<，=）以及如何按降序排序。
	 * @param range
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Employee> searchBySalaryGreaterThan(int salary) {
		
		log.info("searching all employees with salary greater than: " + salary);
		
		List<Employee> employees = new ArrayList<Employee>();
		
		//create EhCache Search API Query
		Query query = cache.createQuery();
		
		//cast attribute from HashMap
		Attribute<Integer> attribute = (Attribute<Integer>) cacheAttributes.get("salary");
		
		//add query criteria like: 'select {key, value} from Employee where salary >= ${@param salary} ORDER BY salary DESC'
		query.addCriteria(attribute.gt(salary)).addOrderBy(attribute, Direction.DESCENDING);
		query.includeKeys().includeValues();
		
		Results results = query.execute();
		
		for(Result result : results.all()) {
			/*
			log.info("Key: " + result.getKey());
			log.info("Value: " + result.getValue());
			log.info("Value Class: " + result.getValue().getClass());
			*/
			
			Employee employee = (Employee) result.getValue();
			employees.add(employee);
		}
		
		return employees;
	}
	
	/**
	 * Returns salary average for all employees in cache layer. This
	 * example shows how to perform an Aggregation function in a search
	 * query, like SQL select avg(salary) from Employee.
	 * 返回缓存层中所有员工的工资平均值。 
	 * 此示例显示了如何在搜索查询中执行聚合功能，例如来自Employee的SQL select avg（salary）。
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public float getSalaryAverage() {
		
		//create EhCache Search API Query
		Query query = cache.createQuery();
		
		Attribute<Integer> attribute = (Attribute<Integer>) cacheAttributes.get("salary");
		
		//include the ehcache 'average' aggregator
		query.includeAggregator(Aggregators.average(attribute));
		
		//read the only value in the aggregator result list
		float average = (Float) query.execute().all().iterator().next().getAggregatorResults().get(0);
		
		return average;
	}
	
	/**
	 * 
	 * @param department
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public int getTotalEmployeesByDepartment(String department) {
		
		//create EhCache Search API Query
		Query query = cache.createQuery();
		
		//cast attribute from HashMap
		Attribute<String> attribute = (Attribute<String>) cacheAttributes.get("department");
		
		//adding query criteria and including count() aggregator
		query.addCriteria(attribute.eq(department));
		query.includeAggregator(Aggregators.count());
		
		//obtaining the only aggregator result for count()
		int totalOfEmployees = (Integer)query.execute().all().iterator().next().getAggregatorResults().get(0);
		
		return totalOfEmployees;
	}
}
