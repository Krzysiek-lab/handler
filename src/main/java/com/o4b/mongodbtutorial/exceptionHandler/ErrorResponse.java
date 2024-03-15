package com.o4b.mongodbtutorial.exceptionHandler;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ErrorResponse {
    private String description;
    private HttpStatus statusCode;
    private String message;
    private String reference;
    private String details;
}
