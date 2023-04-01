package com.rms.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.restaurant.entity.Users;

public interface UserRepository extends JpaRepository<Users, Integer> {

	public Users getUsersByUserName(String userName);
	
	public Users getUsersByRoleAndStatus(String role, String status);
}
