package com.example.productservice.authenticationservice.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.productservice.authenticationservice.model.User;
import com.example.productservice.authenticationservice.repository.UserRepo;

@Service
public class CustomeUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 User user = userRepo.findByUserName(username);
		 return  new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), new ArrayList<>());
	 }
	
	public User save(User user){
		userRepo.save(user);
		return user;
	}

	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}
	 
}
