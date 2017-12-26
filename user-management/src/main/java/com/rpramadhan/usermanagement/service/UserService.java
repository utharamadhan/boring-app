package com.rpramadhan.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rpramadhan.usermanagement.model.User;
import com.rpramadhan.usermanagement.repository.UserRepository;

@Component
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository repository;
	
	
	@Override
	public User findById(Long id) {
		return repository.findOne(id);
	}

	@Override
	public void saveOrUpdate(User book) throws Exception {
		if (book.getId() != null && !isExists(book.getId())) {
			throw new Exception("not found");
		}
		repository.save(book);
	}
	
	private Boolean isExists(Long id) {
		return findById(id) != null;
	}
	
}
