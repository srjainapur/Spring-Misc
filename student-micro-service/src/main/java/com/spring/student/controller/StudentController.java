package com.spring.student.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	
	@RequestMapping(value="/students", method=RequestMethod.GET)
	public String getAllStudents() {
		return "returning all the students";
	}
}
