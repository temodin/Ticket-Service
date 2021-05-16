package com.ticketservice.partner;

import com.ticketservice.partner.model.EventsDTO;
import org.springframework.web.bind.annotation.RequestHeader;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;

public interface PartnerApi {

  @GET("/getEvents")
  Call<EventsDTO> getEvents (@Header("Authorization") String apiKey);
}
