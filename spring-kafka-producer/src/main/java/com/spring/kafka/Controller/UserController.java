package com.spring.kafka.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.kafka.model.User;

@RestController
@RequestMapping("kafka")
public class UserController {
	
	@Autowired
	private KafkaTemplate<String, User> kafkaTemplate;
	
	private static final String TOPIC = "kafkatest";
	
	@GetMapping(value="/publish/{message}")
	public String postMessage(@PathVariable("message") String message) {
		kafkaTemplate.send(TOPIC, "KEY", new User("Samanvi", "DEV", 2000L));
		return "Published successfully";
	}
}
