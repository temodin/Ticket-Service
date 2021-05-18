package com.ticketservice.core.repo;

import com.ticketservice.core.model.UserBankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<UserBankCard,String> {
}
