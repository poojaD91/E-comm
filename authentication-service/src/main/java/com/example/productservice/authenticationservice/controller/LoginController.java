package com.example.productservice.authenticationservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.productservice.authenticationservice.model.AuthRequest;
import com.example.productservice.authenticationservice.model.JwtResponse;
import com.example.productservice.authenticationservice.model.User;
import com.example.productservice.authenticationservice.service.CustomeUserDetailsService;
import com.example.productservice.authenticationservice.utils.JwtUtil;


@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@RestController
@RequestMapping(path = "/api/v1")
public class LoginController {
	
	
	@Autowired
    private JwtUtil jwtUtil;
    @Autowired
    private AuthenticationManager authenticationManager;
    
   @Autowired
   CustomeUserDetailsService userService;
    
  
    @GetMapping("/")
	public String login() {
		return "login successful";
	}
    
  
    @GetMapping(path="/users")
	public List<User> findAll(){
		return this.userService.getAllCustomers();
	}
    
    @PostMapping(path="/register" )
	public ResponseEntity<User> customerCreated(@RequestBody User user){
		User created=userService.save(user);
		return new ResponseEntity<User>(created,HttpStatus.CREATED);
	}
    
    
    @PostMapping(path="/authenticate" ,produces="application/json")
    public ResponseEntity<JwtResponse> generateToken(@RequestBody AuthRequest authRequest) throws Exception {
    	System.out.println("uname: " +authRequest.getUserName());
    	System.out.println("password: " +authRequest.getPassword());
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("inavalid username/password");
        }
        System.out.println("token is : " + jwtUtil.generateToken(authRequest.getUserName()));
        //return jwtUtil.generateToken(authRequest.getUserName());
        String jwt=jwtUtil.generateToken(authRequest.getUserName());
        return new ResponseEntity<JwtResponse>(new JwtResponse(jwt),HttpStatus.OK);
    
    }

}
