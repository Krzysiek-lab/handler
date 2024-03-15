package com.o4b.mongodbtutorial.exceptionHandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(MojException.class)
    public ResponseEntity<ErrorResponse> handleExceptions(final MojException ex, final WebRequest request) {
        log.info("Exception thrown {}", ex.getClass().getName());
        final ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setDescription(ex.getCause().toString());
        errorResponse.setStatusCode(HttpStatus.valueOf(600));
        errorResponse.setMessage(ex.getMessage());
        errorResponse.setDetails(request.getDescription(false));
        return new ResponseEntity<>(errorResponse, errorResponse.getStatusCode());
    }
}
