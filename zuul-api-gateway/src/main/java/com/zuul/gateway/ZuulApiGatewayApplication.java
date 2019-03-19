package com.zuul.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.zuul.gateway.filter.ErrorFilter;
import com.zuul.gateway.filter.PostFilter;
import com.zuul.gateway.filter.PreFilter;
import com.zuul.gateway.filter.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
	}

	@Bean
	public PreFilter preFilter() {
		return new PreFilter();
	}
	
	@Bean
	public PostFilter postFilter() {
		return new PostFilter();
	}
	
	@Bean
	public ErrorFilter errorFilter() {
		return new ErrorFilter();
	}
	
	@Bean
	public RouteFilter routeFilter() {
		return new RouteFilter();
	}
}

