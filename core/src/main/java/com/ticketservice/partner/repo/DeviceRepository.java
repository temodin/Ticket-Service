package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.Event;
import com.ticketservice.partner.model.Seat;
import com.ticketservice.partner.model.UserDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DeviceRepository extends CrudRepository<UserDevice,Long> {

}
