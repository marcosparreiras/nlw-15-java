package com.marcosparreiras.nlw_15_java.exceptions;

public class AttendeeNotFoundException extends DomainException {

  public AttendeeNotFoundException(String attendee) {
    super("Attendee " + attendee + " not found");
  }
}
