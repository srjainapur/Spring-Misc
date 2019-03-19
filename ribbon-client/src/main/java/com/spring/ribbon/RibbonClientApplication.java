package com.spring.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.spring.ribbon.config.RibbonConfiguration;

@EnableDiscoveryClient
@RibbonClient(name="server", configuration=RibbonConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.netflix.client.config.IClientConfig"})
public class RibbonClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RibbonClientApplication.class, args);
	}

}

