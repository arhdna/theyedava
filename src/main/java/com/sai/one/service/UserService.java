package com.sai.one.service;

import com.sai.one.dto.User;

import java.util.List;

/**
 * @author shravan
 */
public interface UserService {

    User findById(long id);

    User saveUser(User user);

    void updateUser(User user);

    void deleteUserById(long id);

    List<User> findAllUsers();

    void deleteAllUsers();

    boolean isUserExist(User user);

}
