package com.example.dndprojectspring.exception;

import org.springframework.http.HttpStatus;

public class NoContentException extends HttpErrorException{

    public NoContentException(String errorMessage, RuntimeException e){
        super(errorMessage, e, HttpStatus.NO_CONTENT);
    }
}
