package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.Event;
import com.ticketservice.partner.model.Seat;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SeatRepository extends CrudRepository<Seat,Long> {
  List<Seat> findByEvent (Event event);

  Optional<Seat> findBySeatIdAndEvent(String id, Event event);
}
