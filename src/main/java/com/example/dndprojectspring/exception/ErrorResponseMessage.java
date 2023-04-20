package com.example.dndprojectspring.exception;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class ErrorResponseMessage {
    private String message;

    @JsonProperty("error-code")
    private HttpStatus errorCode;

    private LocalDateTime timestamp;
}
