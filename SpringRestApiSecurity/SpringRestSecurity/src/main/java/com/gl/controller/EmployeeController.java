package com.gl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gl.dao.UserDAO;
import com.gl.entity.Employee;
import com.gl.entity.User;
import com.gl.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	
	@Autowired
	UserDAO dao;
	
	//get employee list
	
	@GetMapping("/employees")
	public List<Employee> getAllEmp() {
		return service.getAllEmployees();
	}
	
	//add employee
	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.addEmployee(emp);
	}
	
	// delete employee
	@DeleteMapping("/employees/{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        try {
            service.deleteEmployeeById(id);
            return ResponseEntity.ok("Deleted employee id - " + id);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error deleting the employee id-"+id);
        }
    }
	
	//get employee by id
	
	@GetMapping("/employees/{id}")
	public Employee getEmployeeBYId(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	//update employee
	@PutMapping("/employees/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable("id")int id,@RequestBody Employee emp){
		try {
			service.updateEmployeeById(id, emp);
			return ResponseEntity.ok("Updated employee id-"+id);			
		}
		catch (Exception e) {
            return ResponseEntity.status(500).body("Error while updating the employee id-"+id);
        }
	}
	
	//search employee
	@GetMapping("/employees/search") //@PathVariable("firstName") String firstName
	public ResponseEntity<List<Employee>> searchEmployeeByFirstName(@RequestParam String firstName){
		try {
            List<Employee> empList = service.findEmployeesByFirstName(firstName);
            if (empList.isEmpty()) {
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(empList);
            }
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
	}
	
	//sorting all employee in asc and desc order
	
	@GetMapping("/employees/sort")
	public ResponseEntity<List<Employee>> sortbyFirstName(@RequestParam String firstName) {
		List<Employee> empList;
		if("asc".equalsIgnoreCase(firstName)) {
			empList=service.findEmployeesSortedByFirstNameAsc();
		}else if ("desc".equalsIgnoreCase(firstName)) {
			empList=service.findEmployeesSortedByFirstNameDesc();
		}else {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(empList);
	}
	
	// To add user
	@GetMapping("/users")
	public List<User> getAllUsers(){
		
		return dao.findAll();
	}
	
	@PostMapping("/users")
	public User addUsers(@RequestBody User user){
		
		User newUser=new User();
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		newUser.setRoles(user.getRoles());
		return dao.save(newUser);
	}
	
}
