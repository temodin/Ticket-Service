package com.ticketservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ReservationDTO {
  private boolean success = true;
  private String reservationId;

  public ReservationDTO(String reservationId) {
    this.reservationId = reservationId;
  }
}
