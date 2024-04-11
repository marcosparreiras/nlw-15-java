package com.marcosparreiras.nlw_15_java.exceptions;

public class EventAlreadyExistsException extends DomainException {

  public EventAlreadyExistsException(String event) {
    super("Event " + event + " already exists");
  }
}
