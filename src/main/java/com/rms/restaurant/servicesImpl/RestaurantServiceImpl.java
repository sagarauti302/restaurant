package com.rms.restaurant.servicesImpl;

import com.rms.restaurant.entity.Restaurant;

public interface RestaurantServiceImpl {

	public Restaurant saveRestaurantDetails(Restaurant restaurant);
	
	public void deleteRestaurant(Integer id);

	public Restaurant changeStatus(Integer id, Restaurant restaurant);
}
