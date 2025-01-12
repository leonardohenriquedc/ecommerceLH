package com.devleo.project.ecommerce.controllers;

import com.devleo.project.ecommerce.dto.CustomError;
import com.devleo.project.ecommerce.dto.ValidationError;
import com.devleo.project.ecommerce.services.exceptions.DataBaseException;
import com.devleo.project.ecommerce.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ControllerExcpetionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<CustomError> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request){
        HttpStatus status = HttpStatus.NOT_FOUND;

        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status.value()).body(err);
    }

    @ExceptionHandler(DataBaseException.class)
    public ResponseEntity<CustomError> dataBaseException(DataBaseException e, HttpServletRequest request){

        HttpStatus status = HttpStatus.CONFLICT;

        CustomError err = new CustomError(Instant.now(), status.value(), e.getMessage(), request.getRequestURI());

        return ResponseEntity.status(status).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> methodArgumentNotValid(MethodArgumentNotValidException m, HttpServletRequest request){

        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY;

        ValidationError err = new ValidationError(Instant.now(), status.value(), "Dados invalidos", request.getRequestURI());

        for(FieldError f : m.getBindingResult().getFieldErrors()){

            err.addError(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}
