package com.ticketservice.partner.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorDTO {
  private Boolean success;
  private String message;
  private int errorCode;

  public ErrorDTO(String message, int errorCode) {
    this.message = message;
    this.errorCode = errorCode;
  }
}
