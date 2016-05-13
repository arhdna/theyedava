package com.sai.one.repository.jpa;

import com.sai.one.entity.User;
import com.sai.one.repository.UserRepository;

/**
 * Created by shravan
 */
public class UserRepositoryImpl extends JpaRepository implements UserRepository {

    @Override
    public void saveUser(User user) {

    }
}
