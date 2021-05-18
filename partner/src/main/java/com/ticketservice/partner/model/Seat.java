package com.ticketservice.partner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Seat implements Comparable<Seat>{
  @JsonIgnore
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String seatId;
  private int price;
  private Currency currency;

  private boolean reserved;
  @JsonIgnore
  private String reservationId;
  @ManyToOne
  @JoinColumn(name = "event_id")
  @JsonIgnore
  private Event event;

  public Seat(String seatId) {
    this.seatId = seatId;
  }


  @Override
  public int compareTo(Seat seat) {
    if (getNumId() > seat.getNumId()) {
      return 1;}
      else return -1;
  }

  private int getNumId () {
    return Integer.parseInt(seatId.substring(1));
  }
}
