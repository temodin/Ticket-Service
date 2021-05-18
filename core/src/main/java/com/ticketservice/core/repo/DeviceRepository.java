package com.ticketservice.core.repo;

import com.ticketservice.core.model.UserDevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends CrudRepository<UserDevice,String> {

}
