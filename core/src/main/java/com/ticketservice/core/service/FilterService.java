package com.ticketservice.core.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketservice.core.model.ErrorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class FilterService extends OncePerRequestFilter {

  @Autowired
  private PaymentService paymentService;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
      throws ServletException, IOException {
    response.setCharacterEncoding("UTF-8");
    if (request.getHeader("User-Token") == null) {
      String body = convertToJson(new ErrorDTO("A felhasználói token nem szerepel", 10050));
      response.setStatus(401);
      response.getWriter().write(body);
    } else if (!paymentService.isTokenValid(request.getHeader("User-Token"))) {
      String body = convertToJson(new ErrorDTO("A felhasználói token lejárt vagy nem értelmezhető", 10051));
      response.setStatus(401);
      response.getWriter().write(body);
    } else {
      filterChain.doFilter(request, response);
    }
  }

  private String convertToJson(ErrorDTO errorDTO) throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    return mapper.writeValueAsString(errorDTO);
  }

}
