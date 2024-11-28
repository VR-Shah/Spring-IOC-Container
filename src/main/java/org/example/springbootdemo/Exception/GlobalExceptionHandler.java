package org.example.springbootdemo.Exception;

import org.example.springbootdemo.Dto.ApiError;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomExceptionHanlderClass.class)
    public ResponseEntity<ApiError> handleNoSuchElementException(CustomExceptionHanlderClass exception) {
        ApiError apiError = ApiError.builder()
                .message(exception.getMessage())
                .httpStatus(HttpStatus.NOT_FOUND)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {
        List<String> errors = exception.getBindingResult().getAllErrors().stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage).toList();
        ApiError apiError = ApiError.builder()
                .message(errors.toString())
                .httpStatus(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

}
