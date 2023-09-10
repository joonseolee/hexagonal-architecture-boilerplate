package com.joonseolee.infrastructure.validator;


import jakarta.validation.*;

import java.util.Set;

public class ObjectValidator {

    private ObjectValidator() {
        super();
    }
    public static <T> void validate(T object) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(object);

        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

}
