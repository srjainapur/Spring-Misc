package com.spring.exception.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.exception.excep.ProductListIsEmpty;
import com.spring.exception.excep.ProductNotfoundException;
import com.spring.exception.model.Product;

@RestController
public class UserController {

	private static Map<String, Product> prodMap = new HashMap<>();
	static {
		Product honey = new Product();
		honey.setId("1");
		honey.setName("Honey");
		prodMap.put(honey.getId(), honey);

		Product almond = new Product();
		almond.setId("2");
		almond.setName("Almond");
		prodMap.put(almond.getId(), almond);
	}
	
	@RequestMapping(value = "/products/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateProduct(@PathVariable("id") String prodId, @RequestBody Product product) {
		if(!prodMap.containsKey(prodId)) {
			throw new ProductNotfoundException();
		} else {
			prodMap.remove(prodId);
			product.setId(prodId);
			prodMap.put(prodId, product);
			return new ResponseEntity<Object>("Product is updated successfully", HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/product/{id}", method=RequestMethod.GET)
	public ResponseEntity<Product> getProductById(@PathVariable("id") String prodId) {
		if(!prodMap.containsKey(prodId)) {
			throw new ProductNotfoundException();
		} else {
			Product prod = prodMap.get(prodId);
			return new ResponseEntity<Product>(prod, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/all/product" , method=RequestMethod.GET)
	public ResponseEntity<Object> getAllProducts() {
		if(prodMap.isEmpty()) {
			throw new ProductListIsEmpty();
		} else {
			return new ResponseEntity<Object>(prodMap, HttpStatus.OK);
		}
	}
	
	@ExceptionHandler(value=ProductListIsEmpty.class)
	public ResponseEntity<Object> emptyProductHandling(ProductListIsEmpty prodEmpty) {
		return new ResponseEntity<>("Product List is empty", HttpStatus.BAD_REQUEST);
	}
	
	@RequestMapping(value="/product/rm/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> removeProduct(@PathVariable("id") String prodId) {
		if(prodMap.size() == 0 || !prodMap.containsKey(prodId)) {
			throw new ProductListIsEmpty();
		} else {
			prodMap.remove(prodId);
			return new ResponseEntity<Object>(prodMap, HttpStatus.OK);
		}
	}
}
