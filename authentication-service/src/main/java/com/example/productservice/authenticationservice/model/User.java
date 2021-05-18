package com.example.productservice.authenticationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor

@Data

@Entity
@Table(name="USER_Details")
public class User {
	
	@Id
	@GeneratedValue
	int id;
	String userName;
	String password;
	public User(String userName, String password) {
		
		this.userName = userName;
		this.password = password;
	}
	
	

}
