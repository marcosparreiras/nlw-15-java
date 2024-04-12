package com.marcosparreiras.nlw_15_java.exceptions;

public class EventSoldOutException extends DomainException {

  public EventSoldOutException(String event) {
    super("Cold not register, event " + event + " is sold out");
  }
}
