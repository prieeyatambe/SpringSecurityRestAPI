package com.gl.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.gl.dao.UserDAO;
import com.gl.entity.User;

@Service
public class MyUserDetailsService implements UserDetailsService{

	@Autowired
	UserDAO dao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User u1;
		
		if(dao.findById(username).isPresent()) {
			u1=dao.findById(username).get();
		}
		else {
			throw new Error(username+" does not exists");
		}
		return new MyUserDetails(u1);
	}

}
