package com.marcosparreiras.nlw_15_java.exceptions;

public class AttendeeAlreadyExistsException extends DomainException {

  public AttendeeAlreadyExistsException(String attendee) {
    super("Attendee " + attendee + " already exits");
  }
}
