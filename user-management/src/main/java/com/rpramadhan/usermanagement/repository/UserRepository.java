package com.rpramadhan.usermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.rpramadhan.usermanagement.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByEmail(String email);
	
}
