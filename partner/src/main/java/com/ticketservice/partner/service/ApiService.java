package com.ticketservice.partner.service;

import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class ApiService {

  public void checkKey(String apiKey) throws AuthenticationException {
    if (apiKey == null || !apiKey.equals(System.getenv("PARTNER_KEY"))) {
      throw new AuthenticationException("Érvénytelen API azonosító");
    }
  }
}
