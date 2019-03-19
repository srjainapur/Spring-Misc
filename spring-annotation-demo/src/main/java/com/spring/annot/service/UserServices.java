package com.spring.annot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.annot.model.User;
import com.spring.annot.repository.UserJPARepository;


@Service
public class UserServices {
	
	@Autowired
	private UserJPARepository userJPARepository;

	public User registerUser(User user) {
		return userJPARepository.save(user);
	}

	public List<User> getAllUser() {
		return userJPARepository.findAll();
	}

	public Optional<User> getUserById(String userId) {
		// TODO Auto-generated method stub
		return userJPARepository.findById(Long.valueOf(userId));
	}
	
}
