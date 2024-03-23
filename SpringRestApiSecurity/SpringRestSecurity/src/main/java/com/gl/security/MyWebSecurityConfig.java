package com.gl.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
public class MyWebSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService service;
	
	
	public AuthenticationProvider getAuthProvider() {
		DaoAuthenticationProvider dao=new DaoAuthenticationProvider();
		dao.setUserDetailsService(service);
		dao.setPasswordEncoder(getPasswordEncoder());
		return dao;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET,"/api/employees/{id}","/api/employees/sort","/api/employees","/api/employees/search","/users")
		.hasAnyAuthority("admin","user")
		.antMatchers(HttpMethod.POST,"/api/employees","/users")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.DELETE,"/api/employees/{id}")
		.hasAnyAuthority("admin")
		.antMatchers(HttpMethod.PUT,"/api/employees/{id}")
		.hasAnyAuthority("admin")
		.anyRequest().authenticated().and().httpBasic()
		.and().cors().and().csrf().disable();

	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
