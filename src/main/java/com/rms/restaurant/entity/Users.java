package com.rms.restaurant.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USERS")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    
    @NotBlank(message = "Name must be Required")
    @Size(min = 4,max =10,message = "Name must be 4 to 10 character")
    private String userName;
    
    @NotBlank(message = "Email Must be Required..!!")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$",message = "Invalid Email ..!!")
    private String gmail;
    
    @NotBlank(message = "Password Must Be Required !!")
    private String password;
    
    private String role;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "wallet_id", referencedColumnName = "wallet_id")
    private Wallet wallet;
    
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "users",orphanRemoval = true)
    private List<Booking> booking;
    
    private String status;

	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int id,
			@NotBlank(message = "Name must be Required") @Size(min = 4, max = 10, message = "Name must be 4 to 10 character") String userName,
			@NotBlank(message = "Email Must be Required..!!") @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Invalid Email ..!!") String gmail,
			@NotBlank(message = "Password Must Be Required !!") String password, String role, Wallet wallet, String status,
			List<Booking> booking) {
		super();
		this.id = id;
		this.userName = userName;
		this.gmail = gmail;
		this.password = password;
		this.role = role;
		this.wallet = wallet;
		this.booking = booking;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGmail() {
		return gmail;
	}

	public void setGmail(String gmail) {
		this.gmail = gmail;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Wallet getWallet() {
		return wallet;
	}

	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}

	public List<Booking> getBooking() {
		return booking;
	}

	public void setBooking(List<Booking> booking) {
		this.booking = booking;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
   


}
