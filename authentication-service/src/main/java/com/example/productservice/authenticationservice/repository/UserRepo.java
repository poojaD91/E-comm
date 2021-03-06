package com.example.productservice.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.productservice.authenticationservice.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserName(String username) ;
	
	

}
