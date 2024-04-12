package com.marcosparreiras.nlw_15_java.useCases.CheckIn;

import com.marcosparreiras.nlw_15_java.domain.checkIns.CheckInEntity;
import com.marcosparreiras.nlw_15_java.exceptions.AttendeeNotFoundException;
import com.marcosparreiras.nlw_15_java.exceptions.CheckInAlreadyExistsException;
import com.marcosparreiras.nlw_15_java.exceptions.DomainException;
import com.marcosparreiras.nlw_15_java.repositories.AttendeeRepository;
import com.marcosparreiras.nlw_15_java.repositories.CheckInRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckInUseCase {

  @Autowired
  private AttendeeRepository attendeeRepository;

  @Autowired
  private CheckInRepository checkInRepository;

  public CheckInResponseDTO exceute(CheckInRequestDTO requestDTO)
    throws DomainException {
    var attendee = this.attendeeRepository.findById(requestDTO.attendeeId());
    if (attendee.isEmpty()) {
      throw new AttendeeNotFoundException(requestDTO.attendeeId());
    }

    var checkInAlreadyExists =
      this.checkInRepository.findByAttendeeId(requestDTO.attendeeId());
    if (checkInAlreadyExists.isPresent()) {
      throw new CheckInAlreadyExistsException(requestDTO.attendeeId());
    }

    var checkIn =
      this.checkInRepository.save(
          CheckInEntity.builder().attendee(attendee.get()).build()
        );

    return new CheckInResponseDTO(checkIn.getId().toString());
  }
}
