package com.marcosparreiras.nlw_15_java.exceptions;

public class CheckInAlreadyExistsException extends DomainException {

  public CheckInAlreadyExistsException(String attendee) {
    super("Attendee " + attendee + " already checked in");
  }
}
