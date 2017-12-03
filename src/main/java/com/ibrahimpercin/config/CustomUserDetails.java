package com.ibrahimpercin.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.ibrahimpercin.entities.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
	
	private String username;
	private String password;
	Collection<? extends GrantedAuthority> authorities;

	public CustomUserDetails(User byUsername) {
		this.username=byUsername.getUsername();
		this.password=byUsername.getPassword();
		
		List<GrantedAuthority> auths = new ArrayList<>();
		for(Role role: byUsername.getRoles())
			auths.add(new SimpleGrantedAuthority(role.getName().toUpperCase()));
		
		this.authorities=auths;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
