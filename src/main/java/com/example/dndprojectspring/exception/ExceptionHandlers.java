package com.example.dndprojectspring.exception;

import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpErrorException.class)
    ResponseEntity<ErrorResponseMessage> ErrorHandler(HttpErrorException exception){
        ErrorResponseMessage error = new ErrorResponseMessage(
                exception.getMessage(),
                exception.getStatusCode(),
                LocalDateTime.now());
        return new ResponseEntity<>(error, error.getErrorCode());
    }

    @ExceptionHandler(ValidationException.class)
    ResponseEntity<ErrorResponseMessage> ValidationExceptionHandler(ValidationException exception){
        ErrorResponseMessage error = new ErrorResponseMessage(
                exception.getMessage(),
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now());
        return new ResponseEntity<>(error, error.getErrorCode());
    }
}
