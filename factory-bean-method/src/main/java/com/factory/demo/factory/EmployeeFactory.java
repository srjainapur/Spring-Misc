package com.factory.demo.factory;

import com.factory.demo.bean.EmployeeDTO;

public class EmployeeFactory {
	public static EmployeeDTO createEmployeeOfType(String type) {
		if ("manager".equals(type) || "director".equals(type)) {
			EmployeeDTO employee = new EmployeeDTO();

			employee.setEmpId(-1);
			employee.setFirstName("dummy");
			employee.setLastName("dummy");
			// Set designation here
			employee.setDesignation(type);

			return employee;
		} else {
			throw new IllegalArgumentException("Unknown product");
		}
	}
}
