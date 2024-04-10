package com.marcosparreiras.nlw_15_java.repositories;

import com.marcosparreiras.nlw_15_java.domain.checkIns.CheckInEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CheckInRepository
  extends JpaRepository<CheckInEntity, Integer> {
  Optional<CheckInEntity> findByAttendeeId(String attendeeId);
}
