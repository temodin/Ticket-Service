package com.ticketservice.partner.repo;

import com.ticketservice.partner.model.UserBankCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends CrudRepository<UserBankCard,Long> {
}
