package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.UserDtls;

public interface UserRepository extends JpaRepository<UserDtls, Integer> {
	
	public UserDtls findByEmail(String em);

}
