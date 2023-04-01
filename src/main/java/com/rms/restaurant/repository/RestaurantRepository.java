package com.rms.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.restaurant.entity.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer>{

}
