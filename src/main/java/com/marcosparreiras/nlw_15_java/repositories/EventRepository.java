package com.marcosparreiras.nlw_15_java.repositories;

import com.marcosparreiras.nlw_15_java.domain.events.EventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<EventEntity, String> {}
