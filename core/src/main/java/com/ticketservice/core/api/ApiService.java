package com.ticketservice.core.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.ticketservice.core.exception.EventNotFoundException;
import com.ticketservice.core.model.ErrorDTO;
import com.ticketservice.core.model.EventsDTO;
import com.ticketservice.core.model.ReservationDTO;
import com.ticketservice.core.model.ReservationRequestDTO;
import com.ticketservice.core.model.SeatsDTO;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;

@Service
public class ApiService {
  private final String apiKey = System.getenv("PARTNER_KEY");
  private final PartnerApi partnerApi = ApiServiceGenerator.createService(PartnerApi.class);
  private final Gson gson = new GsonBuilder().create();

  public EventsDTO getEvents() throws IOException {
    Response<EventsDTO> response = partnerApi.getEvents(apiKey).execute();
    if (!response.isSuccessful()) {
      throw new IOException();
    }
    return response.body();
  }

  public SeatsDTO getEvent(long eventId) throws IOException, EventNotFoundException {
    Response<JsonObject> response = partnerApi.getEvent(apiKey, eventId).execute();
    if (!response.isSuccessful()) {
      ErrorDTO error = gson.fromJson(response.errorBody().string(), ErrorDTO.class);
      if (error.getErrorCode() == 90001) {
        throw new EventNotFoundException();
      } else {
        throw new IOException();
      }
    }
    SeatsDTO seats = gson.fromJson(response.body().toString(), SeatsDTO.class);
    return seats;
  }

  public ReservationDTO reserve(ReservationRequestDTO request) throws IOException {
    Response<JsonObject> response = partnerApi.reserve(apiKey, request).execute();
    ReservationDTO reservation;
    if (!response.isSuccessful()) {
      ErrorDTO error = gson.fromJson(response.errorBody().string(), ErrorDTO.class);
      reservation = new ReservationDTO(false, Integer.toString(error.getErrorCode()));
    } else {
      reservation = gson.fromJson(response.body().toString(), ReservationDTO.class);
    }
    return reservation;
  }
}

