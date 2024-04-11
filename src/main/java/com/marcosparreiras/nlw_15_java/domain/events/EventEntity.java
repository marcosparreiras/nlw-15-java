package com.marcosparreiras.nlw_15_java.domain.events;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "events")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EventEntity {

  @Id
  @Column(nullable = false)
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String details;

  @Column(nullable = false, unique = true)
  private String slug;

  @Column(name = "maximum_attendees", nullable = false)
  private Integer maximumAttendees;
}
