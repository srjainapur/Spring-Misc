package com.spring.ribbon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name="say-hello-app", configuration=SayHelloConfiguration.class)
public class SayHelloRibbonAppApplication {
	
	@Autowired
	public RestTemplate restTemplate;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@RequestMapping(value="/hi", method=RequestMethod.GET)
	public String sayHi(@RequestParam(value="name", defaultValue="Samanvi") String name) {
		System.out.println("Inside Say hello NAme " + name);
		String greeting = restTemplate.getForObject("http://say-hello-app/greeting", String.class);
		return String.format("%s, %s!", greeting, name);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SayHelloRibbonAppApplication.class, args);
	}

}

