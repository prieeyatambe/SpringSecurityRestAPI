package com.gl.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gl.entity.Employee;

public interface EmployeeDAO extends JpaRepository<Employee, Integer>{

	List<Employee> findByFirstName(String firstName);
}
