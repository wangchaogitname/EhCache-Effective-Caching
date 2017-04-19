package net.danielwind.effcaching.recipe3.services;

import java.util.List;

import net.danielwind.effcaching.recipe3.domain.Employee;

public interface ApplicationService {

	/**
	 * Simple service method for accessing Employees DAO
	 * 访问员工DAO的简单service方法
	 * @return Typed List of all employees available
	 */
	public List<Employee> findAllEmployees();
}
