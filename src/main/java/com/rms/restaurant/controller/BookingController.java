package com.rms.restaurant.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rms.restaurant.entity.Booking;
import com.rms.restaurant.servicesImpl.BookingServiceImpl;

@RestController
public class BookingController {

	@Autowired
	BookingServiceImpl bookingServiceImpl;
	
	@PostMapping("/bookDinner")
	public ResponseEntity<?> bookDinner(@RequestBody Booking booking)
	{
		try {
			return ResponseEntity.ok(bookingServiceImpl.saveBookDinner(booking));
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/cancelDinner/{id}")
	public ResponseEntity<?> cancelDinner(@PathVariable Integer id)
	{
		
		Map<String, Object> map = new HashMap<>();
		try {
			bookingServiceImpl.deleteBooking(id);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
