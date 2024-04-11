package com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees;

import com.marcosparreiras.nlw_15_java.domain.attendees.AttendeeEntity;
import java.util.List;

public record FetchEventAttendeesResponseDTO(List<AttendeeEntity> attendees) {}
