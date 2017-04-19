package net.danielwind.effcaching.recipe9.dao;

import java.util.List;

import net.danielwind.effcaching.recipe9.domain.Employee;

public interface EmployeeDao {
	
	/**
	 * Simple method for retrieving all employees
	 * stored in the database.  
	 * 检索数据库中存储的所有员工的简单方法。
	 * @return Typed List of All Employees
	 */
	public List<Employee> findAll();
}
