package com.rms.restaurant.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rms.restaurant.entity.Restaurant;
import com.rms.restaurant.servicesImpl.RestaurantServiceImpl;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantServiceImpl restaurantServiceImpl;
	
	@PostMapping("/registerRestaurant")
	public ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			restaurantServiceImpl.saveRestaurantDetails(restaurant);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/updateRestaurant")
	public ResponseEntity<?> updateRestaurant(@RequestBody Restaurant restaurant)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			restaurantServiceImpl.saveRestaurantDetails(restaurant);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/deleteRestaurant/{id}")
	public ResponseEntity<?> deleteRestaurant(@PathVariable Integer id)
	{
		
		Map<String, Object> map = new HashMap<>();
		try {
			restaurantServiceImpl.deleteRestaurant(id);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/changeStatus/{id}")
	public ResponseEntity<?> changeStatus(@PathVariable Integer id, @RequestBody Restaurant restaurant)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			restaurantServiceImpl.changeStatus(id, restaurant);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
		
	}
}
