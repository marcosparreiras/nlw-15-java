package com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees;

import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventNotFoundException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import com.marcosparreiras.nlw_15_java.repositories.CheckInRepository;
import com.marcosparreiras.nlw_15_java.repositories.EventRepository;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FetchEventAttendeesUseCase {

  @Autowired
  private AttendeeRepository attendeeRepository;

  @Autowired
  private EventRepository eventRepository;

  @Autowired
  private CheckInRepository checkInRepository;

  public FetchEventAttendeesResponseDTO execute(
    FetchEventAttendeesRequestDTO requestDTO
  ) throws DomainException {
    var event = this.eventRepository.findById(requestDTO.eventId());
    if (event.isEmpty()) {
      throw new EventNotFoundException(requestDTO.eventId());
    }

    var attendees = this.attendeeRepository.findByEventId(requestDTO.eventId());

    var eventAttendees = attendees
      .stream()
      .map(attendee -> {
        var checkIn = this.checkInRepository.findByAttendeeId(attendee.getId());
        var checkInAt = checkIn.isPresent()
          ? checkIn.get().getCreatedAt()
          : null;

        return EventAttendeesDTO
          .builder()
          .id(attendee.getId())
          .name(attendee.getName())
          .email(attendee.getEmail())
          .createdAt(attendee.getCreatedAt())
          .checkInAt(checkInAt)
          .build();
      })
      .collect(Collectors.toList());

    return new FetchEventAttendeesResponseDTO(
      eventAttendees.size(),
      eventAttendees
    );
  }
}
