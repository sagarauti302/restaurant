package com.rms.restaurant.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wallet")
public class Wallet {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name = "wallet_id")
	 private int wallet_id;
	 
	 private long wallet_balance;
	 
	 private String wallet_status;
	 
	 @OneToOne(mappedBy = "wallet")
	 private Users users;

	public int getWallet_id() {
		return wallet_id;
	}

	public void setWallet_id(int wallet_id) {
		this.wallet_id = wallet_id;
	}

	public long getWallet_balance() {
		return wallet_balance;
	}

	public void setWallet_balance(long wallet_balance) {
		this.wallet_balance = wallet_balance;
	}

	public String getWallet_status() {
		return wallet_status;
	}

	public void setWallet_status(String wallet_status) {
		this.wallet_status = wallet_status;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Wallet(int wallet_id, long wallet_balance, String wallet_status, Users users) {
		super();
		this.wallet_id = wallet_id;
		this.wallet_balance = wallet_balance;
		this.wallet_status = wallet_status;
		this.users = users;
	}

	@Override
	public String toString() {
		return "Wallet [wallet_id=" + wallet_id + ", wallet_balance=" + wallet_balance + ", wallet_status="
				+ wallet_status + ", users=" + users + "]";
	}

	public Wallet() {
		super();
		// TODO Auto-generated constructor stub
	}
	 
	 
	

}
