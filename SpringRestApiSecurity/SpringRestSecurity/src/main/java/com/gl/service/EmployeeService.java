package com.gl.service;

import java.util.List;

import com.gl.entity.Employee;

public interface EmployeeService {

	public List<Employee> getAllEmployees();
	public Employee addEmployee(Employee emp);
	public Employee getEmployeeById(int id);
	public void deleteEmployeeById(int id);
	public Employee updateEmployeeById(int id,Employee emp);
	public List<Employee> findEmployeesByFirstName(String firstName);
	public List<Employee> findEmployeesSortedByFirstNameDesc();
	public List<Employee> findEmployeesSortedByFirstNameAsc();

}
