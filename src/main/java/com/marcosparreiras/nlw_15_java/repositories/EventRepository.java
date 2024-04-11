package com.marcosparreiras.nlw_15_java.repositories;

import com.marcosparreiras.nlw_15_java.domain.events.EventEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, String> {
  Optional<EventEntity> findBySlug(String slug);
}
