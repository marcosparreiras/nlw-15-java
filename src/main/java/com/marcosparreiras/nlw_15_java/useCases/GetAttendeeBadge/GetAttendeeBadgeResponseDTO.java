package com.marcosparreiras.nlw_15_java.useCases.GetAttendeeBadge;

import java.time.LocalDateTime;
import lombok.Builder;

@Builder
public record GetAttendeeBadgeResponseDTO(
  String id,
  String name,
  String email,
  String event,
  LocalDateTime createdAt,
  String checkInUrl
) {}
