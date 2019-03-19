package com.spring.mongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.spring.mongo.model.User;

public interface UserRepository extends MongoRepository<User, String>{

}
