package com.gl.dao;

import org.springframework.data.jpa.repository.JpaRepository;


import com.gl.entity.User;

public interface UserDAO extends JpaRepository<User, String>{

}
