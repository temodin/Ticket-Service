package com.ticketservice.partner.exception;

import com.ticketservice.partner.model.ErrorDTO;
import org.apache.tomcat.websocket.AuthenticationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = EventNotFoundException.class)
  public ResponseEntity<ErrorDTO> noSuchEventException(Exception ex) {
    return ResponseEntity.status(400).body(new ErrorDTO("Nem létezik ilyen esemény!", 90001));
  }

  @ExceptionHandler(value = SeatNotFoundException.class)
  public ResponseEntity<ErrorDTO> noSuchSeatException(Exception ex) {
    return ResponseEntity.status(400).body(new ErrorDTO("Nem létezik ilyen szék!", 90002));
  }

  @ExceptionHandler(value = SeatReservedException.class)
  public ResponseEntity<ErrorDTO> seatReservedException(Exception ex) {
    return ResponseEntity.status(400).body(new ErrorDTO("Már lefoglalt székre nem lehet jegyet eladni!", 90010));
  }

  @ExceptionHandler(value = AuthenticationException.class)
  public ResponseEntity<ErrorDTO> authException(Exception ex) {
    return ResponseEntity.status(401).body(new ErrorDTO(ex.getMessage(), 90020));
  }
}
