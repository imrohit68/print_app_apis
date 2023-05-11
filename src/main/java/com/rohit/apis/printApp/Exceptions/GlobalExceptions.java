package com.rohit.apis.printApp.Exceptions;

import com.rohit.apis.printApp.Payloads.Responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptions {

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<ApiResponse> userAlreadyExistsException(UserAlreadyExists ex){
        String message = ex.getMessage();
        return new ResponseEntity<>(new ApiResponse(message,false),HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException ex){
        String message = ex.getMessage();
        ApiResponse apiResponse= new ApiResponse(message,false);
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }
}
