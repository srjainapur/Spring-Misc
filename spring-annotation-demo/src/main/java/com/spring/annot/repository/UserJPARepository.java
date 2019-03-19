package com.spring.annot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.annot.model.User;


@Repository
public interface UserJPARepository extends JpaRepository<User, Long> {

}
