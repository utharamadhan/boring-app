package com.rpramadhan.usermanagement.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rpramadhan.usermanagement.model.Response;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello", method=RequestMethod.GET)
	public ResponseEntity<Response> getHello() {
		Response resp = new Response();
			resp.setResponseCode("00");
			resp.setResponseDesc("success");
			resp.setResult("Hello from UserManagement");
		return ResponseEntity.ok().body(resp);
	}
	
}
