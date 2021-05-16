package com.ticketservice.partner.controller;

import com.ticketservice.partner.model.Event;
import com.ticketservice.partner.model.EventsDTO;
import com.ticketservice.partner.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class ApiController {

  @Autowired
  private ApiService apiService;

  @GetMapping("/getEvents")
  public ResponseEntity<EventsDTO> returnEvents() throws IOException {
    EventsDTO events = apiService.getEvents();
    return ResponseEntity.ok(events);
  }

//  @GetMapping("/getEvent/{eventId}")
//  public ResponseEntity<SeatsDTO> returnSeats(@PathVariable long eventId,
//                                              @RequestHeader(name = "Authorization", required = false) String apiKey)
//      throws EventNotFoundException, AuthenticationException {
//    apiService.checkKey(apiKey);
//    return ResponseEntity.ok(eventService.returnSeats(eventId));
//  }
//
//  @PostMapping("/reserve")
//  public ResponseEntity<ReservationDTO> reserveSeat(@RequestBody ReservationRequestDTO request,
//                                                    @RequestHeader (name = "Authorization", required = false) String apiKey)
//      throws ReservationException, AuthenticationException {
//    apiService.checkKey(apiKey);
//    ReservationDTO reservation = eventService.reserveSeat(request);
//    return ResponseEntity.ok(reservation);
//  }

}
