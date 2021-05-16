package com.ticketservice.partner.model;

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
public class UserToken {

    @Id
    private String token;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
