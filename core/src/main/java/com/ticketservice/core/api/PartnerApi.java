package com.ticketservice.core.api;

import com.google.gson.JsonObject;
import com.ticketservice.core.model.EventsDTO;
import com.ticketservice.core.model.ReservationDTO;
import com.ticketservice.core.model.ReservationRequestDTO;
import com.ticketservice.core.model.SeatsDTO;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PartnerApi {

  @GET("/getEvents")
  Call<EventsDTO> getEvents (@Header("Authorization") String apiKey);

  @GET("/getEvent/{eventId}")
  Call<JsonObject> getEvent (@Header("Authorization") String apiKey, @Path("eventId") long eventId);

  @POST("/reserve/")
  Call<JsonObject> reserve (@Header("Authorization") String apiKey, @Body ReservationRequestDTO request);

}
