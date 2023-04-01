package com.rms.restaurant.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Booking")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int bookingId;
	
	private long bookingAmount;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id" ,nullable = false)
	private Users users;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "tableId", referencedColumnName = "tableId")
	 private Tables tables;
	 
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name = "restaurantId", referencedColumnName = "restaurantId")
	 private Restaurant restaurant;

	public Booking() {
		super();
		
	}

	public Booking(int bookingId, long bookingAmount, Users users, Tables tables, Restaurant restaurant) {
		super();
		this.bookingId = bookingId;
		this.bookingAmount = bookingAmount;
		this.users = users;
		this.tables = tables;
		this.restaurant = restaurant;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public long getBookingAmount() {
		return bookingAmount;
	}

	public void setBookingAmount(long bookingAmount) {
		this.bookingAmount = bookingAmount;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Tables getTables() {
		return tables;
	}

	public void setTables(Tables tables) {
		this.tables = tables;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	 
	 
	
}
