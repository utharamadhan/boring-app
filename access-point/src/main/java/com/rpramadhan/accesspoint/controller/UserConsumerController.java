package com.rpramadhan.accesspoint.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rpramadhan.accesspoint.main.User;
import com.rpramadhan.accesspoint.model.Response;

@RestController
public class UserConsumerController {

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(method=RequestMethod.POST, value="/user/register")
	public ResponseEntity<Object> getItems(@RequestBody User user) {
		HttpEntity<User> request = new HttpEntity<>(user, getHeaders());
		ResponseEntity<Response> response = restTemplate.exchange("http://USER-MANAGEMENT/register", HttpMethod.POST, request, Response.class);
		return ResponseEntity.ok().body(response.getBody());
	}
	
	private static HttpHeaders getHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setContentType(MediaType.APPLICATION_JSON);
		return headers;
	}
	
}
