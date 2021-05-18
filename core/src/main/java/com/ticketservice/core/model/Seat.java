package com.ticketservice.core.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat {
  private String seatId;
  private int price;
  private Currency currency;
  private boolean reserved;

}
