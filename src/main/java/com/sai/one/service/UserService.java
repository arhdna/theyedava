package com.sai.one.service;

import java.util.List;

import com.sai.one.dto.User;

/**
 * 
 * @author shravan
 *
 */
public interface UserService {

	User findById(long id);

	User saveUser(User user);

	void updateUser(User user);

	void deleteUserById(long id);

	List<User> findAllUsers();

	void deleteAllUsers();

	public boolean isUserExist(User user);

}
