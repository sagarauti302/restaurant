package com.rms.restaurant.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.restaurant.entity.Restaurant;
import com.rms.restaurant.repository.RestaurantRepository;
import com.rms.restaurant.servicesImpl.RestaurantServiceImpl;

@Service
public class RestaurantService implements RestaurantServiceImpl{

	@Autowired 
	RestaurantRepository restaurantRepository;
	
	@Override
	public Restaurant saveRestaurantDetails(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}
	@Override
	public void deleteRestaurant(Integer id) {
		restaurantRepository.deleteById(id);
	}
	
	@Override
	public Restaurant changeStatus(Integer id, Restaurant restaurant) {
		 Restaurant restaurant2 = restaurantRepository.getById(id);
		 restaurant2.setStatus(restaurant.getStatus());
		 return restaurantRepository.save(restaurant2);
	}

}
