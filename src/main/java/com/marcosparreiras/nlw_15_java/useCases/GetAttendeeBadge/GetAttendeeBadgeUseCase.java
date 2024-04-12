package com.marcosparreiras.nlw_15_java.useCases.GetAttendeeBadge;

import com.marcosparreiras.nlw_15_java.exceptions.AttendeeNotFoundException;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAttendeeBadgeUseCase {

  @Autowired
  private AttendeeRepository attendeeRepository;

  public GetAttendeeBadgeResponseDTO execute(
    GetAttendeeBadgeRequestDTO requestDTO
  ) throws DomainException {
    var attendee = this.attendeeRepository.findById(requestDTO.attendeeId());
    if (attendee.isEmpty()) {
      throw new AttendeeNotFoundException(requestDTO.attendeeId());
    }

    var checkInUrl =
      requestDTO.baseUrl() +
      "/attendees/" +
      attendee.get().getId() +
      "/check-in";

    return GetAttendeeBadgeResponseDTO
      .builder()
      .id(attendee.get().getId())
      .name(attendee.get().getName())
      .email(attendee.get().getEmail())
      .event(attendee.get().getEvent().getTitle())
      .createdAt(attendee.get().getCreatedAt())
      .checkInUrl(checkInUrl)
      .build();
  }
}
