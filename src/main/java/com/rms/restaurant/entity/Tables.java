package com.rms.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "TABLES")
public class Tables {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int tableId;
    
    private String tableName;
    
    private String status;
    
    @ManyToMany(mappedBy = "tables",fetch = FetchType.LAZY )
    private List<Restaurant> restaurant;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private Users users;
    
    @OneToOne(mappedBy = "tables")
    private Booking booking;

	public Tables() {
		super();
	}

	public Tables(int tableId, String tableName, String status, List<Restaurant> restaurant, Users users,
			Booking booking) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.status = status;
		this.restaurant = restaurant;
		this.users = users;
		this.booking = booking;
	}

	public int getTableId() {
		return tableId;
	}

	public void setTableId(int tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Restaurant> getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(List<Restaurant> restaurant) {
		this.restaurant = restaurant;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	
    
}
