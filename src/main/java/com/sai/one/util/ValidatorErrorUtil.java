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
        if (list.isPresent()&&!list.get().isEmpty()) {
            resp = Optional.of(populateError(list.get(),HttpStatus.BAD_REQUEST));
        }
        return resp;
    }

    public ResponseEntity<Entity> populateError(List<? extends Object> listErrs, HttpStatus httpStatus) {
        GenericError error = new GenericError();
        error.setMessage(listErrs);
        return new ResponseEntity<>(error, httpStatus);
    }

    public ResponseEntity<Entity> populateCatch(Exception e, HttpStatus httpStatus) {
        List<String> listErrs = new ArrayList<>();
        listErrs.add(e.getMessage());
        e.printStackTrace();
        return populateError(listErrs, httpStatus);
    }
}
