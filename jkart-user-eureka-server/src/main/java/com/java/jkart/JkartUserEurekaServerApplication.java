package com.java.jkart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JkartUserEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JkartUserEurekaServerApplication.class, args);
	}

}

