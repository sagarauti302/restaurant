package com.rms.restaurant.servicesImpl;

import java.util.Map;

import com.rms.restaurant.entity.Booking;

public interface BookingServiceImpl {

	public Map<String, Object> saveBookDinner(Booking booking);
	
	public void deleteBooking(Integer id);
}
