package com.ticketservice.partner.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketservice.partner.exception.ReservationException;
import com.ticketservice.partner.model.ReservationRequestDTO;
import com.ticketservice.partner.service.ApiService;
import com.ticketservice.partner.service.EventService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class PartnerControllerTest {

  private final ObjectMapper mapper = new ObjectMapper();

  @Autowired
  private MockMvc mockMvc;

  @Test
  @DisplayName("should complete a reservation. works only if test environment varible 'PARTNER_KEY' is added")
  public void shouldReserveTicket() throws Exception {
    ReservationRequestDTO request = new ReservationRequestDTO(1L,"S4");
    mockMvc.perform(post("/reserve")
        .header("Authorization",System.getenv("PARTNER_KEY"))
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(request)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.success", is(true)))
        .andExpect(jsonPath("$.reservationId", notNullValue()));
  }
  @Test
  @DisplayName("should return an error DTO. works only if test environment varible 'PARTNER_KEY' is added")
  public void shouldReturnError() throws Exception {
    ReservationRequestDTO request = new ReservationRequestDTO(1L,"S1");
    mockMvc.perform(post("/reserve")
        .header("Authorization",System.getenv("PARTNER_KEY"))
        .contentType(MediaType.APPLICATION_JSON)
        .content(mapper.writeValueAsString(request)))
        .andExpect(status().is4xxClientError())
        .andExpect(jsonPath("$.message", is("Már lefoglalt székre nem lehet jegyet eladni!")))
        .andExpect(jsonPath("$.errorCode", is(90010)));
  }


}