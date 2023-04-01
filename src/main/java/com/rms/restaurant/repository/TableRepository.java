package com.rms.restaurant.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.restaurant.entity.Tables;

public interface TableRepository extends JpaRepository<Tables, Integer>{

}
