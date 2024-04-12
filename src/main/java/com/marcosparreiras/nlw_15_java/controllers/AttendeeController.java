package com.marcosparreiras.nlw_15_java.controllers;

import com.marcosparreiras.nlw_15_java.useCases.GetAttendeeBadge.GetAttendeeBadgeRequestDTO;
import com.marcosparreiras.nlw_15_java.useCases.GetAttendeeBadge.GetAttendeeBadgeResponseDTO;
import com.marcosparreiras.nlw_15_java.useCases.GetAttendeeBadge.GetAttendeeBadgeUseCase;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

  @Autowired
  private GetAttendeeBadgeUseCase getAttendeeBadgeUseCase;

  @GetMapping("/{attendeeId}")
  public ResponseEntity<GetAttendeeBadgeResponseDTO> getAttendeeBadge(
    @PathVariable String attendeeId,
    HttpServletRequest httpRequest
  ) throws Exception {
    String baseUrl = httpRequest
      .getRequestURL()
      .toString()
      .replace(httpRequest.getRequestURI(), "");
    var request = new GetAttendeeBadgeRequestDTO(attendeeId, baseUrl);
    var response = this.getAttendeeBadgeUseCase.execute(request);
    return ResponseEntity.ok().body(response);
  }
}
