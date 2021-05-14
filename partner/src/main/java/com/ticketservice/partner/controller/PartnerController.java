package com.ticketservice.partner.controller;

import com.ticketservice.partner.exception.EventNotFoundException;
import com.ticketservice.partner.exception.ReservationException;
import com.ticketservice.partner.exception.SeatNotFoundException;
import com.ticketservice.partner.exception.SeatReservedException;
import com.ticketservice.partner.model.EventsDTO;
import com.ticketservice.partner.model.SeatsDTO;
import com.ticketservice.partner.model.ReservationDTO;
import com.ticketservice.partner.model.ReservationRequestDTO;
import com.ticketservice.partner.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {

  @Autowired
  private EventService eventService;

  @GetMapping("/getEvents")
  public ResponseEntity<EventsDTO> returnEvents() throws EventNotFoundException {
    return ResponseEntity.ok(eventService.returnEvents());
  }

  @GetMapping("/getEvent/{eventId}")
  public ResponseEntity<SeatsDTO> returnSeats(@PathVariable long eventId) throws EventNotFoundException {
    return ResponseEntity.ok(eventService.returnSeats(eventId));
  }

  @PostMapping("/reserve")
  public ResponseEntity<ReservationDTO>reserveSeat(@RequestBody ReservationRequestDTO request)
      throws ReservationException {
    ReservationDTO reservation = eventService.reserveSeat(request);
    return ResponseEntity.ok(reservation);
  }

  //TODO
  // add authorization header
  //add a function to check if token is from the ticket module
  // add environment var to store the ticket module's token

}
