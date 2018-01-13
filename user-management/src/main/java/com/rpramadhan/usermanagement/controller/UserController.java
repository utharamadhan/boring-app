package com.rpramadhan.usermanagement.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpramadhan.usermanagement.model.Response;
import com.rpramadhan.usermanagement.model.User;
import com.rpramadhan.usermanagement.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService service;
	
	private static Map<String, String> exceptions = new HashMap<>();
	static {
		exceptions.put("01", "email is required");
		exceptions.put("02", "full name is required");
		exceptions.put("03", "password is required");
		exceptions.put("04", "email already exists");
		exceptions.put("05", "User is not found");
	}
	
	private User validateRequest(User user) throws IllegalArgumentException {
		if (StringUtils.isEmpty(user.getEmail())) {
			throw new IllegalArgumentException("01");
		} else if(StringUtils.isEmpty(user.getFullName())) {
			throw new IllegalArgumentException("02");
		} else if(StringUtils.isEmpty(user.getPassword())) {
			throw new IllegalArgumentException("03");
		} else if(service.isExistsByEmail(user.getEmail())) {
			throw new IllegalArgumentException("04");
		}
		return user;
	}
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ResponseEntity<Response> post(@RequestBody User user) {
		Response resp = new Response();
		try {
			service.saveOrUpdate(validateRequest(user));
			resp.setResponseCode("00");
			resp.setResponseDesc("success");
			resp.setResult(user);
			return ResponseEntity.ok().body(resp);	
		} catch (Exception ex) {
			resp.setResponseCode(ex.getMessage());
			resp.setResponseDesc(exceptions.containsKey(ex.getMessage()) ? exceptions.get(ex.getMessage()) : null);
			return ResponseEntity.badRequest().body(resp);
		}
	}
	
}
