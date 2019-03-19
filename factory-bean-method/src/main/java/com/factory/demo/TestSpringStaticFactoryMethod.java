package com.factory.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.factory.demo.bean.EmployeeDTO;

public class TestSpringStaticFactoryMethod {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
		EmployeeDTO manager = (EmployeeDTO)context.getBean("manager");
		System.out.println(manager);
	}
}
