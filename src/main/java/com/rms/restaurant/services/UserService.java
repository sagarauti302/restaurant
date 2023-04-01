package com.rms.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.restaurant.entity.Users;
import com.rms.restaurant.repository.UserRepository;
import com.rms.restaurant.servicesImpl.UserServiceImpl;

@Service
public class UserService implements UserServiceImpl{

	
	@Autowired 
	UserRepository userRepository;
	@Override
	public Users saveUserDetail(Users userDetail) {
		return userRepository.save(userDetail);
	}
	
	@Override
	public Users getUserDeatilsById(Integer id) {
		return userRepository.getById(id);
	}

	@Override
	public Users getUsersByRoleAndStatus(String role, String Status) {
		return null;
	}


}
