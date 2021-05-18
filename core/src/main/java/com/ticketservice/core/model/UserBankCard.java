package com.ticketservice.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class UserBankCard {
  @Id
  private String cardId;
  private long cardNumber;
  private int cvc;
  private String name;
  private int amount;
  private Currency currency;
  @ManyToOne
  @JoinColumn(name = "user_id")
  private User user;
}
