package com.ticketservice.partner.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SeatsDTO {
  private EventSeats data;
  private boolean success = true;

  public SeatsDTO(EventSeats data) {
    this.data = data;
  }
}
