package com.ticketservice.partner.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Event {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String title;
private String location;
private long startTimeStamp;
private long endTimeStamp;
@JsonIgnore
@OneToMany(mappedBy = "event")
private List<Seat> seats;

  public Event(long id) {
    this.id = id;
  }
}
