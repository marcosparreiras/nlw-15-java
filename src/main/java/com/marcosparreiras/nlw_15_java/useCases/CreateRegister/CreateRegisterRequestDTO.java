package com.marcosparreiras.nlw_15_java.useCases.CreateRegister;

public record CreateRegisterRequestDTO(
  String name,
  String email,
  String eventId
) {
} 
