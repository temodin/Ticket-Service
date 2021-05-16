package com.ticketservice.partner.controller;

import com.ticketservice.partner.exception.EventNotFoundException;
import com.ticketservice.partner.exception.ReservationException;
import com.ticketservice.partner.model.EventsDTO;
import com.ticketservice.partner.model.ReservationDTO;
import com.ticketservice.partner.model.ReservationRequestDTO;
import com.ticketservice.partner.model.SeatsDTO;
import com.ticketservice.partner.service.ApiService;
import com.ticketservice.partner.service.EventService;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartnerController {

  @Autowired
  private EventService eventService;

  @Autowired
  private ApiService apiService;

  @GetMapping("/getEvents")
  public ResponseEntity<EventsDTO> returnEvents(@RequestHeader(name = "Authorization", required = false) String apiKey)
      throws EventNotFoundException, AuthenticationException {
    apiService.checkKey(apiKey);
    return ResponseEntity.ok(eventService.returnEvents());
  }

  @GetMapping("/getEvent/{eventId}")
  public ResponseEntity<SeatsDTO> returnSeats(@PathVariable long eventId,
                                              @RequestHeader(name = "Authorization", required = false) String apiKey)
      throws EventNotFoundException, AuthenticationException {
    apiService.checkKey(apiKey);
    return ResponseEntity.ok(eventService.returnSeats(eventId));
  }

  @PostMapping("/reserve")
  public ResponseEntity<ReservationDTO> reserveSeat(@RequestBody ReservationRequestDTO request,
                                                    @RequestHeader (name = "Authorization", required = false) String apiKey)
      throws ReservationException, AuthenticationException {
    apiService.checkKey(apiKey);
    ReservationDTO reservation = eventService.reserveSeat(request);
    return ResponseEntity.ok(reservation);
  }

}
