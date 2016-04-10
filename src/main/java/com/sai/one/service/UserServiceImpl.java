package com.sai.one.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sai.one.dto.User;
/**
 * 
 * @author shravan
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	public User findById(long id) {
		return null;
	}

	public User saveUser(User user) {
		return user;
	}

	public void updateUser(User user) {
		
	}

	public void deleteUserById(long id) {
		
	}

	public List<User> findAllUsers() {
		return null;
	}

	public void deleteAllUsers() {
		
	}

	public boolean isUserExist(User user) {
		return false;
	}
	
}
