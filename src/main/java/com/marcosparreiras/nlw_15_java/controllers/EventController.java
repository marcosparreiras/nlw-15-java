package com.marcosparreiras.nlw_15_java.controllers;

import com.marcosparreiras.nlw_15_java.useCases.CreateEvent.CreateEventRequestDTO;
import com.marcosparreiras.nlw_15_java.useCases.CreateEvent.CreateEventResponseDTO;
import com.marcosparreiras.nlw_15_java.useCases.CreateEvent.CreateEventUseCase;
import com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees.FetchEventAttendeesRequestDTO;
import com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees.FetchEventAttendeesResponseDTO;
import com.marcosparreiras.nlw_15_java.useCases.FetchEventAttendees.FetchEventAttendeesUseCase;
import com.marcosparreiras.nlw_15_java.useCases.GetEvent.GetEventRequestDTO;
import com.marcosparreiras.nlw_15_java.useCases.GetEvent.GetEventResponseDTO;
import com.marcosparreiras.nlw_15_java.useCases.GetEvent.GetEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private GetEventUseCase getEventUseCase;

  @Autowired
  private CreateEventUseCase createEventUseCase;

  @Autowired
  private FetchEventAttendeesUseCase fetchEventAttendeesUseCase;

  @PostMapping("")
  public ResponseEntity<CreateEventResponseDTO> createEvent(
    @RequestBody CreateEventRequestDTO requestDTO
  ) throws Exception {
    var response = this.createEventUseCase.execute(requestDTO);
    return ResponseEntity.status(HttpStatus.CREATED).body(response);
  }

  @GetMapping("/{eventId}")
  public ResponseEntity<GetEventResponseDTO> getEvent(
    @PathVariable String eventId
  ) throws Exception {
    var request = new GetEventRequestDTO(eventId);
    var response = this.getEventUseCase.execute(request);

    return ResponseEntity.ok().body(response);
  }

  @GetMapping("/{eventId}/attendees")
  public ResponseEntity<FetchEventAttendeesResponseDTO> fetchEventAttendees(
    @PathVariable String eventId
  ) throws Exception {
    var request = new FetchEventAttendeesRequestDTO(eventId);
    var response = this.fetchEventAttendeesUseCase.execute(request);
    return ResponseEntity.ok().body(response);
  }
}
