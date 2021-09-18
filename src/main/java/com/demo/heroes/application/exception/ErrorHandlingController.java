package com.demo.heroes.application.exception;

import javax.validation.ConstraintViolationException;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@Slf4j
@ControllerAdvice
public class ErrorHandlingController extends ResponseEntityExceptionHandler {

  @ExceptionHandler(value = Exception.class)
  public ResponseEntity<HeroExceptionResponse> generalException(Exception e) {
    HeroExceptionResponse heroExceptionResponse = new HeroExceptionResponse();
    heroExceptionResponse.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
    heroExceptionResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(heroExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }


  @ExceptionHandler(value = ConstraintViolationException.class)
  public ResponseEntity<HeroExceptionResponse> constraintException(Exception e) {
    HeroExceptionResponse heroExceptionResponse = new HeroExceptionResponse();
    heroExceptionResponse.setCode(HttpStatus.BAD_REQUEST.value());
    heroExceptionResponse.setMessage(e.getMessage());
    return new ResponseEntity<>(heroExceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
