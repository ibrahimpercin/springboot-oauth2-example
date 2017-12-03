package com.ibrahimpercin;

import java.util.Arrays;

import com.ibrahimpercin.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.ibrahimpercin.config.CustomUserDetails;
import com.ibrahimpercin.repo.UserRepo;

@SpringBootApplication
public class AuthRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthRestApplication.class, args);
	}
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder, UserRepo repo) throws Exception {
		if(repo.count() == 0)
			repo.save(new User("user","user",Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
		builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUsername(s));
			}
		});
	}
}
