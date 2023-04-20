package com.example.dndprojectspring.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends HttpErrorException{

    public NotFoundException(String errorMessage, RuntimeException e){
        super(errorMessage, e, HttpStatus.NOT_FOUND);
    }
}
