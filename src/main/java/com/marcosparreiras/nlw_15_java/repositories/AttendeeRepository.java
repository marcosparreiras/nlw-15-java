package com.marcosparreiras.nlw_15_java.repositories;

import com.marcosparreiras.nlw_15_java.domain.attendees.AttendeeEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendeeRepository
  extends JpaRepository<AttendeeEntity, String> {
  List<AttendeeEntity> findByEventId(String eventId);

  Optional<AttendeeEntity> findByEventIdAndEmail(String eventId, String email);
}
