package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<UserToken, Long> {
}
