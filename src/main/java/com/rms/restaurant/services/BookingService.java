package com.rms.restaurant.services;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.restaurant.entity.Booking;
import com.rms.restaurant.entity.Restaurant;
import com.rms.restaurant.entity.Tables;
import com.rms.restaurant.entity.Users;
import com.rms.restaurant.repository.BookingRepository;
import com.rms.restaurant.repository.RestaurantRepository;
import com.rms.restaurant.repository.TableRepository;
import com.rms.restaurant.servicesImpl.BookingServiceImpl;
import com.rms.restaurant.servicesImpl.UserServiceImpl;

@Service
public class BookingService implements BookingServiceImpl{

	@Autowired 
	BookingRepository bookingRepository;
	
	@Autowired 
	UserServiceImpl userServiceImpl;
	
	@Autowired
	TableRepository tableRepository;
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@SuppressWarnings("deprecation")
	@Override
	public Map<String, Object> saveBookDinner(Booking booking) {
		Map<String, Object> map = new HashMap<>();
		Users usersDetail = userServiceImpl.getUserDeatilsById(booking.getUsers().getId());
		Restaurant restaurant = restaurantRepository.getById(booking.getRestaurant().getRestaurantId());
		Tables tables = tableRepository.getById(booking.getTables().getTableId());
		if(restaurant.getStatus().equals("Active")) { 
		if(!tables.getStatus().equals("Reserved")) {
			map.put("message", "This is reserved table.");
		}else {
		booking.setUsers(usersDetail);
		booking.setTables(tables);
		booking.setRestaurant(restaurant);
		 bookingRepository.save(booking);
		
		usersDetail.getWallet().setWallet_balance(usersDetail.getWallet().getWallet_balance() - booking.getBookingAmount());
		userServiceImpl.saveUserDetail(usersDetail);
		
		long adminCharge = booking.getBookingAmount()/10; 
		
		Users adminUser = userServiceImpl.getUsersByRoleAndStatus("Admin", "Active");
		adminUser.getWallet().setWallet_balance(adminCharge);
		userServiceImpl.saveUserDetail(adminUser);

		Users manager = userServiceImpl.getUsersByRoleAndStatus("Manager", "Active");
		manager.getWallet().setWallet_balance(booking.getBookingAmount() - adminCharge);
		userServiceImpl.saveUserDetail(manager);
		
		map.put("status", "success");
		map.put("data", restaurant);
		}
		}else {
			map.put("status", "failed");
			map.put("message", "This restaurant is not Active.");
		}
		return map;
	}

	@Override
	public void deleteBooking(Integer id) {
		bookingRepository.deleteById(id);
		
	}

}
