package com.java.jkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class JkartUserProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkartUserProfileApplication.class, args);
	}

}

