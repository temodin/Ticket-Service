package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
  public List<Event> findAll ();
}
