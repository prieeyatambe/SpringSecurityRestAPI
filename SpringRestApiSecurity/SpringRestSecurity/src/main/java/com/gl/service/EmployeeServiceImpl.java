package com.gl.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.gl.dao.EmployeeDAO;
import com.gl.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO dao;

	@Override
	public List<Employee> getAllEmployees() {
		return dao.findAll();
	}

	@Override
	public Employee addEmployee(Employee emp) {
		
		return dao.save(emp);
	}

	@Override
	public void deleteEmployeeById(int id) {

		Optional<Employee> optinal=dao.findById(id);
		if(optinal.isPresent()) {
			dao.deleteById(id);	
		}
		
	}

	@Override
	public List<Employee> findEmployeesByFirstName(String firstName) {
		
		return dao.findByFirstName(firstName);
	}

	@Override
	public Employee updateEmployeeById(int id, Employee newEmp) {
		
		Optional<Employee> optinal=dao.findById(id);
		if(optinal.isPresent()) {
			Employee oldEmp=optinal.get();
			oldEmp.setFirstName(newEmp.getFirstName());
			oldEmp.setLastName(newEmp.getLastName());
			oldEmp.setEmail(newEmp.getEmail());
			dao.save(oldEmp);
			return oldEmp;
		}
		return null;
		
	}

	@Override
	public Employee getEmployeeById(int id) {
		
		Optional<Employee> optional=dao.findById(id);
		return optional.get();
	}

	@Override
	public List<Employee> findEmployeesSortedByFirstNameDesc() {
		
		return dao.findAll(Sort.by(Sort.Direction.ASC, "firstName"));
	}

	@Override
	public List<Employee> findEmployeesSortedByFirstNameAsc() {
		
		return dao.findAll(Sort.by(Sort.Direction.DESC, "firstName"));

	}

	

}
