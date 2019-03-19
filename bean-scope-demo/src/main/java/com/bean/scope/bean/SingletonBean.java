package com.bean.scope.bean;

import org.springframework.beans.factory.annotation.Autowired;

public class SingletonBean {
	private String type;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getType() {
		return type;
	}
	
	public SingletonBean() {
		System.out.println("Singleton instance created");
	}
	
	@Autowired
	private PrototypeBean prototypeBean;
	
	@Autowired
	private PrototypeBean protoBean;
	
	public PrototypeBean getProtoBean() {
		System.out.println("Getting Proto Bean");
		return protoBean;
	}
	
	public PrototypeBean getPrototypeBean() {
		System.out.println("Getting Prototype Bean");
		return prototypeBean;
	}
	
}
