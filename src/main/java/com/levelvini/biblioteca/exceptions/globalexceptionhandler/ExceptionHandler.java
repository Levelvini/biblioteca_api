package com.levelvini.biblioteca.exceptions.globalexceptionhandler;

import com.levelvini.biblioteca.exceptions.ResourseNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(ResourseNotFoundException.class)
    public ResponseEntity<ErrorResponse> HandlerResourseNotFoundException(ResourseNotFoundException e){
        ErrorResponse errorResponse = new ErrorResponse("erro de resposta: " + e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> HandlerGenericsException(Exception e){
        ErrorResponse errorResponse = new ErrorResponse("erro interno: " + e.getMessage());
        return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
