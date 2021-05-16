package com.ticketservice.partner.service;

import com.ticketservice.partner.PartnerApi;
import com.ticketservice.partner.model.EventsDTO;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import retrofit2.Call;

import java.io.IOException;

@Service
public class ApiService {
  private final String apiKey = System.getenv("PARTNER_KEY");
  private final PartnerApi partnerApi = ApiServiceGenerator.createService(PartnerApi.class);

 public EventsDTO getEvents () throws IOException {
   Call<EventsDTO> call = partnerApi.getEvents(apiKey);
   return call.execute().body();
 }

  }

