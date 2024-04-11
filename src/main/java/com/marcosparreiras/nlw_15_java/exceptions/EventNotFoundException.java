package com.marcosparreiras.nlw_15_java.exceptions;

public class EventNotFoundException extends DomainException {

  public EventNotFoundException(String event) {
    super("Event " + event + " not found");
  }
}
