package com.marcosparreiras.nlw_15_java.useCases.CreateEvent;

public record CreateEventRequestDTO(
  String title,
  String details,
  int maximumAttendees
) {}
