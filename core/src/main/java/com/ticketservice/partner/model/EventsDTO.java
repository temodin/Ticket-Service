package com.ticketservice.partner.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class EventsDTO {
  private List<Event> data;
  private boolean success = true;

  public EventsDTO(List<Event> data) {
    this.data = data;
  }
}
