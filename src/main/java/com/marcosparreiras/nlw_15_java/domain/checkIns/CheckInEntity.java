package com.marcosparreiras.nlw_15_java.domain.checkIns;

import com.marcosparreiras.nlw_15_java.domain.attendees.AttendeeEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "check_ins")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CheckInEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(name = "created_at")
  @CreationTimestamp
  private LocalDateTime createdAt;

  @OneToOne
  @JoinColumn(name = "attendee_id", nullable = false)
  private AttendeeEntity attendee;
}
