package com.rms.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.restaurant.entity.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer>{

}
