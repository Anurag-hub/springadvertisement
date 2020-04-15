package com.firstadvertisement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstadvertisement.entity.User;
import com.firstadvertisement.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userservice;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public User registerUser(@RequestBody User user) {
		return userservice.save(user);
	}
	@RequestMapping(value="/login")
	public String loginUser(@RequestBody User user){
		return userservice.login(user);
	}
	@RequestMapping(value="/getuser")
	public User getUserById(@RequestHeader(name="auth-token") String authToken) {
			return userservice.getCurrentUserDetails(authToken);
	}
	@RequestMapping(value="/getallusers")
	public List<User> getAllUsers() {
			return userservice.getAllUsers();
	}
	@RequestMapping(value="/logout")
	public User logoutUser(@RequestHeader(name="auth-token") String authToken) {
		return userservice.logout(authToken);
	}
}

