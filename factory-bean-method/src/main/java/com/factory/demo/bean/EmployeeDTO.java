package com.factory.demo.bean;

public class EmployeeDTO {
	private Integer empId;
	private String firstName;
	private String lastName;
	private String designation;
	
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	public Integer getEmpId() {
		return empId;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getDesignation() {
		return designation;
	}

	@Override
	public String toString() {
		return "EmployeeDTO [empId=" + empId + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
				+ designation + "]";
	}
}
