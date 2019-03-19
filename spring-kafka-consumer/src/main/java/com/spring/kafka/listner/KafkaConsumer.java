package com.spring.kafka.listner;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.spring.kafka.model.User;

@Service
public class KafkaConsumer {
	
	@KafkaListener(topics="kafkatest", groupId="group_json", containerFactory="kafkaListenerContainerFactory")
	public void consume(User user) {
		System.out.println("Consumed JSON Message: " + user);
	}
}
