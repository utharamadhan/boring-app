package com.rpramadhan.usermanagement.service;

import com.rpramadhan.usermanagement.model.User;

public interface IUserService {
	
	public User findById(Long id);
	
	public User findByEmail(String email);
	
	public Boolean isExistsByEmail(String email);
	
	public void saveOrUpdate(User user) throws Exception;

}
