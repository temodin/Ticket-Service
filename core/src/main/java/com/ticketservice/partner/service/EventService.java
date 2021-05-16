package com.ticketservice.partner.service;

import com.ticketservice.partner.exception.EventNotFoundException;
import com.ticketservice.partner.exception.ReservationException;
import com.ticketservice.partner.exception.SeatNotFoundException;
import com.ticketservice.partner.exception.SeatReservedException;
import com.ticketservice.partner.model.Event;
import com.ticketservice.partner.model.EventSeats;
import com.ticketservice.partner.model.EventsDTO;
import com.ticketservice.partner.model.Seat;
import com.ticketservice.partner.model.SeatsDTO;
import com.ticketservice.partner.model.ReservationDTO;
import com.ticketservice.partner.model.ReservationRequestDTO;
import com.ticketservice.partner.repo.UserRepository;
import com.ticketservice.partner.repo.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private DeviceRepository deviceRepository;

  public EventsDTO returnEvents() throws EventNotFoundException {
    List<Event> events = userRepository.findAll();
    if (events.size() == 0) {
      throw new EventNotFoundException();
    }
    return new EventsDTO(events);
  }

  public SeatsDTO returnSeats(long eventId) throws EventNotFoundException {
    List<Seat> seats = deviceRepository.findByEvent(new Event(eventId));
    if (seats.size() == 0) {
      throw new EventNotFoundException();
    }
    EventSeats eventSeats = new EventSeats(eventId, seats.stream().sorted().collect(Collectors.toList()));
    return new SeatsDTO(eventSeats);
  }

  public ReservationDTO reserveSeat(ReservationRequestDTO request) throws ReservationException {
    userRepository.findById(request.getEventId()).orElseThrow(EventNotFoundException::new);
    Seat seat = deviceRepository.findBySeatIdAndEvent(request.getSeatId(),new Event(request.getEventId()))
        .orElseThrow(SeatNotFoundException::new);
    if (seat.isReserved()) {throw new SeatReservedException();}
    String reservationId = UUID.randomUUID().toString();
    seat.setReserved(true);
    seat.setReservationId(reservationId);
    deviceRepository.save(seat);
    return new ReservationDTO(reservationId);
  }
}