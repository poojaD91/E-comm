package com.example.productservice.authenticationservice.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor

@Data
public class JwtResponse {
	
	String token;
	String type="Bearer";
	
	
	public JwtResponse(String token) {
		this.token = token;
	}
	

}
