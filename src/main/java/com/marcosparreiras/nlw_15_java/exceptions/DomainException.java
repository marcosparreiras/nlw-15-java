package com.marcosparreiras.nlw_15_java.exceptions;

public abstract class DomainException extends Exception {

  protected DomainException(String message) {
    super(message);
  }
}
