package com.example.productservice.authenticationservice.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.productservice.authenticationservice.filter.JwtFilter;
import com.example.productservice.authenticationservice.service.CustomeUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	 @Autowired
	    private CustomeUserDetailsService userDetailsService;

	    @Autowired
	    private JwtFilter jwtFilter;

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(userDetailsService);
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }
	    

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
		
	    	
	    	http.csrf().disable()
	        .authorizeRequests().antMatchers("/api/v1/authenticate").permitAll().mvcMatchers(HttpMethod.GET ,"/api/**")
	                  .permitAll().mvcMatchers(HttpMethod.POST ,"api/**").permitAll().anyRequest().authenticated()
	     			  .and().exceptionHandling().and().sessionManagement()
	    			 .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().cors();
	    			  http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	    }
	    
	    
}
