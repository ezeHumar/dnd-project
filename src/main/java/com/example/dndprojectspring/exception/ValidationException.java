package com.example.dndprojectspring.exception;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;

import java.util.stream.Collectors;

public class ValidationException extends HttpErrorException{

    public ValidationException(ConstraintViolationException e) {
        super(getViolationsMessage(e), e, HttpStatus.BAD_REQUEST);
    }

    public ValidationException(String message, ConstraintViolationException e) {
        super(message, e, HttpStatus.BAD_REQUEST);
    }

    private static String getViolationsMessage(ConstraintViolationException e) {
        return e.getConstraintViolations().stream()
                .map(cv -> constructErrorMessage(cv))
                .collect(Collectors.joining(", "));
    }

    private static String constructErrorMessage(ConstraintViolation cv){
        String propertyPath = cv.getPropertyPath().toString();
        String property = propertyPath.substring(propertyPath.lastIndexOf('.') + 1);
        String message = cv.getMessage();
        return property + " " + message;
    }
}
