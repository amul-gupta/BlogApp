package com.mycode.BlogApp.exception;
import com.mycode.BlogApp.exception.ApiErrorResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //resource not found
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiErrorResponse> handleResourceNotFound(ResourceNotFoundException ex) {

        ApiErrorResponse response = ApiErrorResponse.builder()
                .message(ex.getMessage())
                .status(404)
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    // Handle generic exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiErrorResponse> handleGlobalException(Exception ex) {

        ApiErrorResponse response = ApiErrorResponse.builder()
                .message(ex.getMessage())
                .status(404)
                .timestamp(LocalDateTime.now())
                .build();

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
