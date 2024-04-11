package com.marcosparreiras.nlw_15_java.useCases.GetEvent;

import com.marcosparreiras.nlw_15_java.domain.events.EventEntity;

public record GetEventResponseDTO(EventEntity event, int attendeeAmount) {}
