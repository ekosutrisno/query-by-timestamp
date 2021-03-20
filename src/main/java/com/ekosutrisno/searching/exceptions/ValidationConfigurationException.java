package com.ekosutrisno.searching.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.Set;

/**
 * @author Eko Sutrisno
 * Saturday, 20/03/2021 9:25
 */
@Component
public class ValidationConfigurationException {

    private final Validator validator;

    @Autowired
    public ValidationConfigurationException(Validator validator) {
        this.validator = validator;
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> error = validator.validate(object);
        if (error.size() != 0)
            throw new ConstraintViolationException(error);
    }
}
