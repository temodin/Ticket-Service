package com.ticketservice.core.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class User {
  @Id
  private long userId;
  private String name;
  private String email;
  @OneToMany (mappedBy = "user")
  private List<UserDevice> devices;
  @OneToMany (mappedBy = "user")
  private List<UserToken> tokens;
  @OneToMany (mappedBy = "user")
  private List<UserBankCard> cards;

}
