package com.example.dndprojectspring.exception;

import org.springframework.http.HttpStatus;

public class ForbiddenException extends HttpErrorException{

    public ForbiddenException(String errorMessage, RuntimeException e){
        super(errorMessage, e, HttpStatus.FORBIDDEN);
    }
}
