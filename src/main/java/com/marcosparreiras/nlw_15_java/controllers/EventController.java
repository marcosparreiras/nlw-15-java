package com.marcosparreiras.nlw_15_java.controllers;

import com.marcosparreiras.nlw_15_java.controllers.dtos.ResponseErrorDTO;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.useCases.GetEvent.GetEventRequestDTO;
import com.marcosparreiras.nlw_15_java.useCases.GetEvent.GetEventUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

  @Autowired
  private GetEventUseCase getEventUseCase;

  @GetMapping("/{eventId}")
  public ResponseEntity<Object> show(@PathVariable String eventId) {
    try {
      var request = new GetEventRequestDTO(eventId);
      var response = this.getEventUseCase.execute(request);

      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      if (e instanceof DomainException) {
        return ResponseEntity
          .badRequest()
          .body(new ResponseErrorDTO(e.getMessage()));
      }
      e.printStackTrace();
      return ResponseEntity
        .badRequest()
        .body(new ResponseErrorDTO("Internal server error"));
    }
  }
}
