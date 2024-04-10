package com.marcosparreiras.nlw_15_java.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/events")
public class EventController {

  @GetMapping("")
  public ResponseEntity<Object> helloWorld() {
    return ResponseEntity.ok().body("Hello from events controller");
  }
}
