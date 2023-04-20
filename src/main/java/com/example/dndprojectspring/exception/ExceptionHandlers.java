package com.example.dndprojectspring.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlers extends ResponseEntityExceptionHandler {

    @ExceptionHandler(HttpErrorException.class)
    ResponseEntity<ErrorResponseMessage> NotFoundErrorHandler(HttpErrorException exception){
        ErrorResponseMessage error = new ErrorResponseMessage(
                exception.getMessage(),
                exception.getStatusCode(),
                LocalDateTime.now());
        return new ResponseEntity<>(error, error.getErrorCode());
    }
}
