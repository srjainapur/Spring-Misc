package com.spring.annot.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.annot.model.User;
import com.spring.annot.service.UserServices;

@RestController
@RequestMapping("/spring")
public class SpringController {
	
	@Autowired
	public UserServices userServices;
	
	// This method will get invoked for /spring
	@RequestMapping(value="", method=RequestMethod.GET)
	public String methodWithoutMapping() {
		return "Method without method level mapping";
	}
	
	// Method get invoked for bot GET & POST request
	@RequestMapping(value="/getPost", method={RequestMethod.GET, RequestMethod.POST})
	public String getPostMethod() {
		return "Method will get invoked for both GET & POST request";
	}
	
	// Method will get invoked for different request mapping
	@RequestMapping(value={"/first", "/second", "/third"}, method=RequestMethod.GET)
	public String multiRequestMapping() {
		return "Method will get invoked for multiple Request Mapping";
	}
	
	// @PathVariable demo - when request url varibale name & argument name is different
	@RequestMapping(value="/byUserId/{userId}", method=RequestMethod.GET)
	public User getUserById(@PathVariable("userId") String id) {
		Optional<User> userById = userServices.getUserById(id);
		if(userById.isPresent()) {
			return userById.get();
		} else {
			return new User();
		}
	}
	
	// @PathVaribale demo when request url variable & parameter name same
	@RequestMapping(value="/sameVariable/{userId}", method=RequestMethod.GET)
	public User getUserByIdd(@PathVariable String userId) {
		Optional<User> userById = userServices.getUserById(userId);
		if(userById.isPresent()) {
			return userById.get();
		} else {
			return new User();
		}
	}
	
	// @RequestParam example
	// Let’s say that we have an endpoint /request/param that takes a query parameter called id:
	@RequestMapping(value="/request/param", method=RequestMethod.GET)
	public User getUserByReqParam(@RequestParam("id") String userId) {
		Optional<User> userById = userServices.getUserById(userId);
		if(userById.isPresent()) {
			return userById.get();
		} else {
			return new User();
		}
	}
	
	@RequestMapping(value="/multi/param", method=RequestMethod.GET)
	public String multipleRequestParam(@RequestParam("id") String userId, @RequestParam("name") String fName) {
		return "Multiple @RequestParam example Id = " + userId + " name = " + fName;
	}
	
	//annotation’s attributes: name, value, required and defaultValue.
	
	
	// Making an Optional Request Parameter
	// Method parameters annotated with @RequestParam are required by default. This means that if the parameter isn’t present in the request, we’ll get an error:
	// http://localhost:8082/spring/optional/req/param?id=28
	@RequestMapping(value="/optional/req/param")
	public String optionalReqParameter(@RequestParam("id") String userId, @RequestParam(name="name", required=false) String fname) {
		return "Example of Optional Request Param ID = " + userId + " Optional name = " + fname;
	}
	
	// A Default Value for the Request Parameter. We can also set a default value to the @RequestParam by using the defaultValue attribute:
	// http://localhost:8082/spring/default/val?id=30
	@RequestMapping(value="/default/val", method=RequestMethod.GET)
	public String defaultReqParam(@RequestParam("id") String userId, @RequestParam(name="name", defaultValue="Avishka") String name) {
		return "Default value for request Param id = " + userId + " Name = " + name;
	}
	
	// Mapping All Parameters We can also have multiple parameters without defining their names or count by just using Map:
	// http://localhost:8082/spring/allParam?id=31&name=Anita&address=Rajajinagar&city=Bangalore
	@RequestMapping(value="/allParam", method=RequestMethod.GET)
	public String mapAllReqParam(@RequestParam Map<String, String> allParam) {
		return "All request Params Map : " + allParam;
	}
	
	// Mapping a Multi-Value Parameter. A single @RequestParam can have multiple values:
	
	//http://localhost:8082/spring/multi/value?id=10&id=20&id=30
	//http://localhost:8082/spring/multi/value?id=10,20,30,40
		
	@RequestMapping(value="/multi/value", method=RequestMethod.GET)
	public String multiValueParam(@RequestParam("id") List<String> userIds) {
		return "Multiple value for same parameter userIds : " + userIds;
	} 
	
	// Encoded vs Exact Value
	// Because @PathVariable is extracting values from the URI path, it’s not encoded. On the other hand, @RequestParam is.
	
	// http://localhost:8082/spring/exactVal/ab+c
	
	@RequestMapping(value="/exactVal/{userId}", method=RequestMethod.GET)
	public String exactValue(@PathVariable("userId") String userId) {
		return "@PathVariable will not encode path variable userId = " + userId;
	}
	
	// http://localhost:8082/spring/encoded?userId=ab+c
	// output = @RequestParam will encode request param userId = ab c
	
	@RequestMapping(value="/encoded", method=RequestMethod.GET)
	public String encodedValue(@RequestParam("userId") String userId) {
		return "@RequestParam will encode request param userId = " + userId;
	}
}
