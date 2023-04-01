package com.rms.restaurant.servicesImpl;

import com.rms.restaurant.entity.Users;

public interface UserServiceImpl {
	public Users saveUserDetail(Users userDetail);

	public Users getUserDeatilsById(Integer id);

	public Users getUsersByRoleAndStatus(String role, String Status);

}
