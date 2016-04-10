package com.sai.one.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sai.one.dto.User;
import com.sai.one.dto.UserCredentials;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<User> login(@RequestBody UserCredentials credentials) {
		return null;
		
	}

}
