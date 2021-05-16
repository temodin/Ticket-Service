package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.Event;
import com.ticketservice.partner.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

}
