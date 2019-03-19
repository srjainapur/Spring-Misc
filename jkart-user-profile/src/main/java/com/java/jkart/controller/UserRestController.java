package com.java.jkart.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.java.jkart.exception.UserNotFoundException;
import com.java.jkart.model.User;
import com.java.jkart.services.UserServices;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	private UserServices userServices;
	
	// Method to register new User
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerUser(@RequestBody User user) {
		
		User registerUser = userServices.registerUser(user);
		if(registerUser != null && registerUser.getUserId() > 0) {
			return "User Registered Successfully !!!!!!!";
		} else {
			return "User Registeration Failed !!!!!!!";
		}
	}
	
	// Get All the User
	@RequestMapping(value="/allUser", method=RequestMethod.GET)
	public List<User> getAllUser() {
		return userServices.getAllUser();
	}
	
	@RequestMapping(value="/findById/{userId}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("userId") String userId) {
		Optional<User> user = userServices.getUserById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}
	
	// Multiple RequestMapping & RequestParam demo
	/*@RequestMapping(value={"/findById/{userId}", "/getById/{userId}"}, method=RequestMethod.GET)
	public User getUserByUserId(@RequestParam("userId") String userId) {
		Optional<User> user = userServices.getUserById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}*/
	
	@RequestMapping(value={"/findById", "/getById"}, method=RequestMethod.GET)
	public User getUserByUserId(@RequestParam("userId") String userId) {
		Optional<User> user = userServices.getUserById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String defaultRequestHandler() {
		return "Default Request Handler Executed";
	}
	
	
	// Same Method for different HTTP method GET & POST
	@RequestMapping(value="/diffHttp/{userId}", method={RequestMethod.GET, RequestMethod.POST})
	public User getUserByIds(@PathVariable("userId") String userId) {
		Optional<User> user = userServices.getUserById(userId);
		if(!user.isPresent()) {
			throw new UserNotFoundException();
		}
		return user.get();
	}
	
	@RequestMapping(value="*", method=RequestMethod.GET)
	public String defaultMethod() {
		return "This method will be invoked for any request /user/*******";
	}
}
