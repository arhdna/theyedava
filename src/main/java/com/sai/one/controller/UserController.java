package com.sai.one.controller;

import com.sai.one.constants.UrlConstants;
import com.sai.one.dto.EmptyEntity;
import com.sai.one.dto.Entity;
import com.sai.one.dto.User;
import com.sai.one.dto.UserOptional;
import com.sai.one.service.UserService;
import com.sai.one.util.ClassTransformUtil;
import com.sai.one.util.RabbitMQUtil;
import com.sai.one.util.ValidatorErrorUtil;
import com.sai.one.validators.UserCreateValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * @author shravan
 */
@RestController
@RequestMapping(UrlConstants.CONTROLLER)
public class UserController {

    private static final Logger LOGGER = Logger.getLogger(UserController.class.getName());

    @Autowired
    private ValidatorErrorUtil errorUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RabbitMQUtil rabbitMQUtil;

    @Autowired
    private ClassTransformUtil classTransformUtil;

    /**
     * create a user
     *
     * @param user
     * @return Entity
     */
    @RequestMapping(value = UrlConstants.UserController.USER_CREATE, method = RequestMethod.POST)
    public ResponseEntity<Entity> createUser(@RequestBody User user, BindingResult result) {
        LOGGER.info("INSIDE UserController.createUser method with body " + user);
        ResponseEntity<Entity> response;
        try {
            UserOptional userOptional = classTransformUtil.populateUserOptional(user);
            UserCreateValidator validator = new UserCreateValidator();
            Optional<ResponseEntity<Entity>> errorEntity = errorUtil.hasErrors(userOptional, result, validator);
            if (errorEntity.isPresent()) {
                LOGGER.warning("ERROR UserController.createUser method with body " + user);
                return errorEntity.get();
            }
            rabbitMQUtil.sendMessage(user);
            response = new ResponseEntity<>(user, HttpStatus.OK);
        } catch (Exception e) {
            response = errorUtil.populateCatch(e, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        LOGGER.info("COMPLETED UserController.createUser method with body " + user);
        return response;
    }
    
    @RequestMapping(value = UrlConstants.UserController.USER_UPDATE, method = RequestMethod.PUT)
    public ResponseEntity<Entity> updateUser(@RequestBody User user) {
        LOGGER.info("INSIDE RegistrationController.register method with body " + user);
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("COMPLETED RegistrationController.register method with body " + user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @RequestMapping(value = UrlConstants.UserController.USER_DELETE, method = RequestMethod.DELETE)
    public ResponseEntity<Entity> deleteUser() {
        LOGGER.info("INSIDE RegistrationController.register method with body ");
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("COMPLETED RegistrationController.register method with body ");
        return new ResponseEntity<>(new EmptyEntity(), HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = UrlConstants.UserController.USER_GET, method = RequestMethod.GET)
    public ResponseEntity<Entity> getUser() {
        LOGGER.info("INSIDE RegistrationController.register method with body ");
        User user = new User();
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
        LOGGER.info("COMPLETED RegistrationController.register method with body ");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
