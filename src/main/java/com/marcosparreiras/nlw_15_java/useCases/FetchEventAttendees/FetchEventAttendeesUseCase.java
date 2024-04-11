package com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees;

import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventNotFoundException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import com.marcosparreiras.nlw_15_java.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchEventAttendeesUseCase {

  @Autowired
  private AttendeeRepository attendeeRepository;

  @Autowired
  private EventRepository eventRepository;

  public FetchEventAttendeesResponseDTO execute(
    FetchEventAttendeesRequestDTO requestDTO
  ) throws DomainException {
    var event = this.eventRepository.findById(requestDTO.eventId());
    if (event.isEmpty()) {
      throw new EventNotFoundException(requestDTO.eventId());
    }

    var attendees = this.attendeeRepository.findByEventId(requestDTO.eventId());

    return new FetchEventAttendeesResponseDTO(attendees);
  }
}
