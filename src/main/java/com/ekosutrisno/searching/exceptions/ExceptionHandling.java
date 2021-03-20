package com.ekosutrisno.searching.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.HttpStatus.*;

/**
 * @author Eko Sutrisno
 * Saturday, 20/03/2021 9:30
 */
@RestControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ExceptionHandlingResponse<Map<String, String>> validationHandler(ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();
        exception.getConstraintViolations()
                .forEach(error -> errors.put(error.getPropertyPath().toString(), error.getMessage()));

        return new ExceptionHandlingResponse<>(BAD_REQUEST.value(), BAD_REQUEST.getReasonPhrase(), new Date(), errors);
    }

}
