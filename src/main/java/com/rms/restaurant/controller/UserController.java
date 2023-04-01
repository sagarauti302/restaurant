package com.rms.restaurant.controller;

import java.net.http.HttpHeaders;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rms.restaurant.entity.Users;
import com.rms.restaurant.entity.Wallet;
import com.rms.restaurant.helper.JwtUtil;
import com.rms.restaurant.model.JwtRequest;
import com.rms.restaurant.model.JwtResponce;
import com.rms.restaurant.services.CustomUserDetailsService;
import com.rms.restaurant.servicesImpl.UserServiceImpl;

@RestController
public class UserController {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "welcome";
	}
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception{
		
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequest.getUserName(), jwtRequest.getPassword()));
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw new Exception("Bad Credentila");
		}
		
		UserDetails userDetails = this.customUserDetailsService.loadUserByUsername(jwtRequest.getUserName());
		String generateToken = this.jwtUtil.generateToken(userDetails);
		
		return ResponseEntity.ok( new JwtResponce(generateToken));
		
	}
	
	
	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody Users users)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			
			userServiceImpl.saveUserDetail(users);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@GetMapping("/getWalletBalance/{id}")
	public ResponseEntity<?> getWalletBalance(@PathVariable Integer id)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			Users userDetails = userServiceImpl.getUserDeatilsById(id);
			map.put("User name", userDetails.getUserName());
			map.put("Wallet Balance", userDetails.getWallet().getWallet_balance());
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/updateWalletBalance/{id}")
	public ResponseEntity<?> updateWalletBalance(@PathVariable Integer id, @RequestBody Wallet wallet)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			Users userDetails = userServiceImpl.getUserDeatilsById(id);
			wallet.setWallet_id(userDetails.getWallet().getWallet_id());
			userDetails.setWallet(wallet);
			userServiceImpl.saveUserDetail(userDetails);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/approveManager/{id}")
	public ResponseEntity<?> changeStatus(@PathVariable Integer id, @RequestBody Users users)
	{
		Map<String, Object> map = new HashMap<>();
		try {
			Users userDetails = userServiceImpl.getUserDeatilsById(id);
			userDetails.setStatus(users.getStatus());
			userServiceImpl.saveUserDetail(userDetails);
			map.put("status", "success");
			return ResponseEntity.ok(map);
		} catch (Exception e) {
			return ResponseEntity. ok(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
