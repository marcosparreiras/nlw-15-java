package com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record EventAttendeesDTO(
  String id,
  String name,
  String email,
  LocalDateTime createdAt,
  LocalDateTime checkInAt
) {}
