package com.gl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.gl.dao.UserDAO;
import com.gl.entity.User;



@SpringBootApplication
public class SpringRestSecurityApplication implements CommandLineRunner {

//	@Autowired
//	EmployeeService service;
	
	@Autowired
	UserDAO dao;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRestSecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//service.addEmployee(new Employee(102, "jenny", "doe", "jennydoe@gmail.com"));
		//service.addEmployee(new Employee(106, "sarah", "jean", "sarahjean@gmail.com"));
		//service.addEmployee(new Employee(100, "noah", "george", "noahgeorge@gmail.com"));
	
		//User u1=new User("noor", "noor", "admin");
	    //dao.save(u1);
		
		
//		User u1=new User("user","user123","user");
//		u1.setPassword(getEncoder().encode(u1.getPassword()));
//		dao.save(u1);
//		
//		User u2=new User("admin","admin123","admin,user");
//		u2.setPassword(getEncoder().encode(u2.getPassword()));
//		dao.save(u2);
//		
//		User u3=new User("priya","12345","admin");
//		u3.setPassword(getEncoder().encode(u3.getPassword()));
//		dao.save(u3);
		
		
	}
	
//	@Bean
//	public PasswordEncoder getEncoder() {
//		return new BCryptPasswordEncoder();
//	}

}
