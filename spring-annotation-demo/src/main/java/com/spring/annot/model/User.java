package com.spring.annot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "JKART_USER")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "USER_ID", length = 10, nullable = false, unique = true)
	private Long userId;

	@Column(name = "FIRST_NAME", length = 50, nullable = false)
	private String firstName;

	@Column(name = "LAST_NAME", length = 50, nullable = false)
	private String lastName;

	@Column(name = "MIDDLE_NAME", length = 10, nullable = true)
	private String middleName;

	@Column(name = "GENDER", length = 2)
	private String gender;

	@Column(name = "MOBILE_NUM", length = 15)
	private int mobileNo;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(int mobileNo) {
		this.mobileNo = mobileNo;
	}
}
