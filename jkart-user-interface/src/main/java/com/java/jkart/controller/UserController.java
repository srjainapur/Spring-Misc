package com.java.jkart.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.java.jkart.model.User;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class UserController {
	
	@Autowired
	public EurekaClient eurekaClient;
	
	@Autowired
	public RestTemplate restTemplate;
	
	@RequestMapping(value="/user", method=RequestMethod.GET)
	public User[] getAllUser() {
		User[] forObject = restTemplate.getForObject(getServiceUrl()+"/allUser", User[].class);
		return forObject;
	}
	
	public String getServiceUrl() {
		InstanceInfo nextServerFromEureka = eurekaClient.getNextServerFromEureka("USER-PROFILE", false);
		System.out.println("Home Page Url " + nextServerFromEureka.getHomePageUrl());
		System.out.println("HOST NAME : " + nextServerFromEureka.getHostName() + " PORT NUMBER " + nextServerFromEureka.getPort());
		return nextServerFromEureka.getHomePageUrl();
	}
}
