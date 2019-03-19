package com.spring.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MyClientSideController {
	@LoadBalanced
	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@RequestMapping(value="/client/frontend", method=RequestMethod.GET)
	public String hi() {
		System.out.println("Inside ribbon client ::::::::::::::::::::: ");
		//String randomString = this.restTemplate.getForObject("http://localhost:8085/backend", String.class);
		return "Server Response :: ";// + randomString;
	}
}
