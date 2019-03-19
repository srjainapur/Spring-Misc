package com.bean.scope.bean;

public class PrototypeBean {
	
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public PrototypeBean() {
		System.out.println("Prototype instance created");
	}
}
