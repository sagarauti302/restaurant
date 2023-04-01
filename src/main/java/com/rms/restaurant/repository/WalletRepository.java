package com.rms.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rms.restaurant.entity.Wallet;

public interface WalletRepository extends JpaRepository<Wallet, Integer>{

}
