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
	public User findByEmail(String email) {
		try {
			return repository.findByEmail(email);
		} catch (Exception ex) {
			return null;
		}
	}
	
	@Override
	public Boolean isExistsByEmail(String email) {
		return findByEmail(email) != null ? true : false;
	}

	@Override
	public void saveOrUpdate(User user) throws Exception {
		if (user.getId() != null && !isExists(user.getId())) {
			throw new IllegalArgumentException("05");
		}
		repository.save(user);
	}
	
	private Boolean isExists(Long id) {
		return findById(id) != null;
	}
	
}
