package com.rpramadhan.usermanagement.controller;

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
	
	@RequestMapping(value = "/register", method=RequestMethod.POST)
	public ResponseEntity<Response> post(@RequestBody User user) {
		Response resp = new Response();
			resp.setResponseCode("00");
			resp.setResponseDesc("success");
		return ResponseEntity.ok().body(resp);
	}
	
}
