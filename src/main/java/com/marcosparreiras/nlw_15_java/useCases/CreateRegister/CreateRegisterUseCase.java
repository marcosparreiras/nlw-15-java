package com.marcosparreiras.nlw_15_java.useCases.CreateRegister;

import com.marcosparreiras.nlw_15_java.domain.attendees.AttendeeEntity;
import com.marcosparreiras.nlw_15_java.exceptions.AttendeeAlreadyExistsException;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventNotFoundException;
import com.marcosparreiras.nlw_15_java.exceptions.EventSoldOutException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import com.marcosparreiras.nlw_15_java.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateRegisterUseCase {

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private AttendeeRepository attendeeRepository;

  public CreateRegisterResponseDTO execute(CreateRegisterRequestDTO requestDTO)
    throws DomainException {
    var event = this.eventRepository.findById(requestDTO.eventId());

    if (event.isEmpty()) {
      throw new EventNotFoundException(requestDTO.eventId());
    }

    var attendeeAlreadyExists =
      this.attendeeRepository.findByEventIdAndEmail(
          requestDTO.eventId(),
          requestDTO.email()
        );

    if (attendeeAlreadyExists.isPresent()) {
      throw new AttendeeAlreadyExistsException(requestDTO.email());
    }

    var attendeesList =
      this.attendeeRepository.findByEventId(requestDTO.eventId());

    if (attendeesList.size() >= event.get().getMaximumAttendees()) {
      throw new EventSoldOutException(event.get().getId());
    }

    var attendee =
      this.attendeeRepository.save(
          AttendeeEntity
            .builder()
            .name(requestDTO.name())
            .email(requestDTO.email())
            .event(event.get())
            .build()
        );

    return new CreateRegisterResponseDTO(attendee.getId());
  }
}
