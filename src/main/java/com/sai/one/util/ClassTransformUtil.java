package com.sai.one.util;

import com.sai.one.dto.User;
import com.sai.one.dto.UserOptional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.function.Function;

@Component
public class ClassTransformUtil {

    @Autowired
    private UserOptional userOptional;
    public UserOptional populateUserOptional(User user) {
       return populateUserOptionalFunction.apply(user);
    }

    /**
     * lamda expression for converting objects
     */
        private Function<User,UserOptional> populateUserOptionalFunction = (User user) -> {
        userOptional.setId(Optional.ofNullable(user.getId()));
        userOptional.setEmail(Optional.ofNullable(user.getEmail()));
        userOptional.setFirstName(Optional.ofNullable(user.getFirstName()));
        userOptional.setLastName(Optional.ofNullable(user.getLastName()));
        userOptional.setPassword(Optional.ofNullable(user.getPassword()));
        return userOptional;
    };

}
