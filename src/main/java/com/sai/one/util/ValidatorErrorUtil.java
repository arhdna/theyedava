package com.sai.one.util;

import com.sai.one.dto.Entity;
import com.sai.one.dto.GenericError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class ValidatorErrorUtil {

    public Optional<ResponseEntity<Entity>> hasErrors(Entity entity, BindingResult result, Validator valid) {
        Optional<ResponseEntity<Entity>> resp = Optional.empty();
        valid.validate(entity, result);
        Optional<List<FieldError>> list = Optional.ofNullable(result.getFieldErrors());
        if (list.isPresent()) {
            resp = Optional.of(populateError(entity, list.get()));
        }
        return resp;
    }

    public ResponseEntity<Entity> populateError(Entity entity, List<? extends Object> listErrs) {
        GenericError error = new GenericError();
        error.setMessage(listErrs);
        return new ResponseEntity<Entity>(entity, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Entity> populateCatch(Exception e) {
        List<String> listErrs = new ArrayList<String>();
        listErrs.add(e.getMessage());
        e.printStackTrace();
        return populateError(new GenericError(), listErrs);
    }
}
