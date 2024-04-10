package com.marcosparreiras.nlw_15_java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attendees")
public class AttendeeController {

  @GetMapping("")
  public ResponseEntity<Object> helloWolrd() {
    return ResponseEntity.ok().body("Hello from attendees controller");
  }
}
