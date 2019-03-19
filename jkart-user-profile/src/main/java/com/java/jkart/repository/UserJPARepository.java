package com.java.jkart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.jkart.model.User;

@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

}
