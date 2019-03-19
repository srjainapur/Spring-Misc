package com.spring.mongo.contoller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.mongo.model.User;
import com.spring.mongo.repository.UserRepository;

@RestController
@RequestMapping("/mongo")
public class UserController {
	private final Logger LOG = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserRepository userRepository;
	
	// Getting all users
	@RequestMapping(value="/alluser", method=RequestMethod.GET)
	public List<User> getAllUser() {
		LOG.info("Getting all users.");
		return userRepository.findAll();
	}
	
	// Getting a user by ID
	@RequestMapping(value="/user/{userId}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("userId") String id) {
		LOG.info("Getting user with ID: {}.", id);
		Optional<User> oneUser = userRepository.findById(id);
		if(oneUser.isPresent()) {
			return oneUser.get();
		} else {
			return new User();
		}
	}
	
	// Adding a new User
	@RequestMapping(value="/adduser", method=RequestMethod.POST)
	public User addNewUser(@RequestBody User user) {
		LOG.info("Saving user.");
		return userRepository.save(user);
	}
	
	@RequestMapping(value = "/settings/{userId}", method = RequestMethod.GET)
	public Object getAllUserSettings(@PathVariable String userId) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get().getUserSettings();
		} else {
			return "User not found.";
		}
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}", method = RequestMethod.GET)
	public String getUserSetting(@PathVariable String userId, @PathVariable String key) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			return user.get().getUserSettings().get(key);
		} else {
			return "User not found.";
		}
	}
	
	@RequestMapping(value = "/settings/{userId}/{key}/{value}", method = RequestMethod.GET)
	public String addUserSetting(@PathVariable String userId, @PathVariable String key, @PathVariable String value) {
		Optional<User> user = userRepository.findById(userId);
		if (user.isPresent()) {
			user.get().getUserSettings().put(key, value);
			userRepository.save(user.get()
					);
			return "Key added";
		} else {
			return "User not found.";
		}
	}
}
