package com.sai.one.validators;

import com.sai.one.constants.ValidationConstants;
import com.sai.one.dto.User;
import com.sai.one.model.UserOptional;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class UserCreateValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        // TODO Auto-generated method stub

        UserOptional user = (UserOptional) target;

        if (!user.getFirstName().isPresent())
            errors.rejectValue("first_name", ValidationConstants.User.FIRST_NAME);

        if (!user.getEmail().isPresent())
            errors.rejectValue("email", ValidationConstants.User.EMAIL);

        if (!user.getPassword().isPresent())
            errors.rejectValue("password", ValidationConstants.User.PASSWORD);
    }

}
