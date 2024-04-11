package com.marcosparreiras.nlw_15_java.useCases.GetEvent;

import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventNotFoundException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import com.marcosparreiras.nlw_15_java.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetEventUseCase {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private AttendeeRepository attendeeRepository;

  public GetEventResponseDTO execute(GetEventRequestDTO requestDTO)
    throws DomainException {
    var event = this.eventRepository.findById(requestDTO.eventId());
    if (event.isEmpty()) {
      throw new EventNotFoundException(requestDTO.eventId());
    }
    var eventAttendees =
      this.attendeeRepository.findByEventId(requestDTO.eventId());

    return new GetEventResponseDTO(event.get(), eventAttendees.size());
  }
}
