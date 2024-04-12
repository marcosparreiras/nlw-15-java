package com.marcosparreiras.nlw_15_java.controllers.advices;

import com.marcosparreiras.nlw_15_java.controllers.dtos.ResponseErrorDTO;
import com.marcosparreiras.nlw_15_java.exceptions.AttendeeNotFoundException;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionEntityHandler {

  @ExceptionHandler(DomainException.class)
  public ResponseEntity<ResponseErrorDTO> handleDomainExceptions(
    DomainException e
  ) {
    if (
      e.getClass().equals(EventNotFoundException.class) ||
      e.getClass().equals(AttendeeNotFoundException.class)
    ) {
      return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body(new ResponseErrorDTO(e.getMessage()));
    }

    return ResponseEntity
      .badRequest()
      .body(new ResponseErrorDTO(e.getMessage()));
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ResponseErrorDTO> handleServerExceptions(
    DomainException e
  ) {
    return ResponseEntity
      .internalServerError()
      .body(new ResponseErrorDTO("Internal server error"));
  }
}
