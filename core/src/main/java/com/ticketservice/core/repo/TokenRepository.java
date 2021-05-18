package com.ticketservice.core.repo;

import com.ticketservice.core.model.UserToken;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends CrudRepository<UserToken, String> {
}
