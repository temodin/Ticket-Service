package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.UserDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<UserDevice,Long> {

}
