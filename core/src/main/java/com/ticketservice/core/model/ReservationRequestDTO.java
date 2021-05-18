package com.ticketservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReservationRequestDTO {
  private long eventId;
  private String seatId;
}
