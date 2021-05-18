package com.ticketservice.core.controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ticketservice.core.exception.EventInThePastException;
import com.ticketservice.core.exception.EventNotFoundException;
import com.ticketservice.core.exception.SeatNotFoundException;
import com.ticketservice.core.exception.SeatReservedException;
import com.ticketservice.core.exception.UserCardException;
import com.ticketservice.core.model.ErrorDTO;
import com.ticketservice.core.model.EventsDTO;
import com.ticketservice.core.model.PaymentDTO;
import com.ticketservice.core.model.ReservationDTO;
import com.ticketservice.core.model.SeatsDTO;
import com.ticketservice.core.api.ApiService;
import com.ticketservice.core.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Response;

import java.io.IOException;

@RestController
public class ApiController {

  private final Gson gson = new GsonBuilder().create();

  @Autowired
  private ApiService apiService;

  @Autowired
  private PaymentService paymentService;

  @GetMapping("/getEvents")
  public ResponseEntity<EventsDTO> returnEvents() throws IOException {
    EventsDTO events = apiService.getEvents();
    return ResponseEntity.ok(events);
  }

  @GetMapping("/getEvent/{eventId}")
  public ResponseEntity<SeatsDTO> returnSeats(@PathVariable long eventId) throws IOException, EventNotFoundException {
    SeatsDTO seats = apiService.getEvent(eventId);
    return ResponseEntity.ok(seats);
  }

  @PostMapping("/pay")
  public ResponseEntity<?> payForTicket(@RequestBody PaymentDTO request,
                                        @RequestHeader(name = "User-Token", required = false) String userToken)
      throws IOException, EventNotFoundException, UserCardException, SeatNotFoundException, EventInThePastException,
      SeatReservedException {
    ReservationDTO reservation = paymentService.payForTicket(userToken,request);
    if (!reservation.isSuccess()) {
      return ResponseEntity.status(406).body(reservation);
    }
      return ResponseEntity.ok(reservation);
    }

}
