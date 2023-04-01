package com.rms.restaurant.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.rms.restaurant.entity.Users;
import com.rms.restaurant.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users users = userRepository.getUsersByUserName(username);
		 if(username.equals(users.getUserName())) {
			 return new User(users.getUserName(), users.getPassword(), new ArrayList<>());
		 }else {
			 throw new UsernameNotFoundException(username);
		 }
	}

}
