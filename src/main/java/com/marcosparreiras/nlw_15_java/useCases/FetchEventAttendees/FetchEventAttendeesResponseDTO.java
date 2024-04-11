package com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees;

import java.util.List;

public record FetchEventAttendeesResponseDTO(
  int total,
  List<EventAttendeesDTO> attendees
) {}
