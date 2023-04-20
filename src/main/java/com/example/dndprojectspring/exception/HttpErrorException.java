package com.example.dndprojectspring.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.Objects;

@Getter
@Setter
public class HttpErrorException extends RuntimeException{

    HttpStatus statusCode;

    public HttpErrorException(String message, RuntimeException e, HttpStatus statusCode){
        super(Objects.toString(message, ""), e);
        this.statusCode = statusCode;
    }
}
