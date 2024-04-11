package com.marcosparreiras.nlw_15_java.useCases.CreateEvent;

import com.marcosparreiras.nlw_15_java.domain.events.EventEntity;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.exceptions.EventAlreadyExistsException;
import com.marcosparreiras.nlw_15_java.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateEventUseCase {

  @Autowired
  private EventRepository eventRepository;

  public CreateEventResponseDTO execute(CreateEventRequestDTO requestDTO)
    throws DomainException {
    var slug = this.convertToSlug(requestDTO.title());

    var eventAlreadyExists = this.eventRepository.findBySlug(slug);
    if (eventAlreadyExists.isPresent()) {
      throw new EventAlreadyExistsException(requestDTO.title());
    }

    var event = EventEntity
      .builder()
      .title(requestDTO.title())
      .slug(slug)
      .details(requestDTO.details())
      .maximumAttendees(requestDTO.maximumAttendees())
      .build();

    this.eventRepository.save(event);
    return new CreateEventResponseDTO(event.getId());
  }

  private String convertToSlug(String input) {
    String normalized = input
      .toLowerCase()
      .trim()
      .replaceAll("[^a-z0-9\\s-]", "")
      .replaceAll("\\s+", "-");
    return normalized;
  }
}
