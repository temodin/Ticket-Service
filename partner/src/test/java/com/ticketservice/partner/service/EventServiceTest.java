package com.ticketservice.partner.service;

import com.ticketservice.partner.exception.EventNotFoundException;
import com.ticketservice.partner.model.Seat;
import com.ticketservice.partner.repo.SeatRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class EventServiceTest {

  @Mock
  SeatRepository seatRepository;

  @InjectMocks
  EventService eventService;

  @Test
  @DisplayName("Should return seats of an event sorted properly")
  public void shouldReturnSeats() throws EventNotFoundException {
    List<Seat> seats = new ArrayList<>();
    seats.add(new Seat("S2"));
    seats.add(new Seat("S1"));
    seats.add(new Seat("S3"));
    when(seatRepository.findByEvent(any())).thenReturn(seats);
  List<Seat> returnedSeats = eventService.returnSeats(1L).getData().getSeats();
  Assertions.assertEquals(seats.get(0),returnedSeats.get(1));
  Assertions.assertEquals(seats.get(1),returnedSeats.get(0));
  Assertions.assertEquals(seats.get(2),returnedSeats.get(2));
  }

  @Test(expected = EventNotFoundException.class)
  @DisplayName("Should return seats of an event sorted properly")
  public void shouldReturnException() throws EventNotFoundException {
    List<Seat> seats = new ArrayList<>();
    when(seatRepository.findByEvent(any())).thenReturn(seats);
    List<Seat> returnedSeats = eventService.returnSeats(1L).getData().getSeats();
  }
}