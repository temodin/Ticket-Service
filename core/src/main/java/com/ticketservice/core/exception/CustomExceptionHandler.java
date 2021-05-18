package com.ticketservice.core.exception;

import com.ticketservice.core.model.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.IOException;
import java.util.Arrays;

@Slf4j
@ControllerAdvice
public class CustomExceptionHandler {

  @ExceptionHandler(value = SeatNotFoundException.class)
  public ResponseEntity<ErrorDTO> noSuchSeatException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(404).body(new ErrorDTO("Nem létezik ilyen szék!", 90002));
  }

  @ExceptionHandler(value = TokenNotFoundException.class)
  public ResponseEntity<ErrorDTO> catchTokenNotFoundException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(404).body(new ErrorDTO("A felhasználói token nem szerepel", 10050));
  }

  @ExceptionHandler(value = TokenInvalidException.class)
  public ResponseEntity<ErrorDTO> catchInvalidTokenException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(401)
        .body(new ErrorDTO("A beérkezett kérésben szereplő felhasználó token lejárt vagy nem értelmezhető", 10051));
  }

  @ExceptionHandler(value = IOException.class)
  public ResponseEntity<ErrorDTO> catchIOException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(404).body(new ErrorDTO("A külső rendszer nem elérhető!", 20404));
  }

  @ExceptionHandler(value = UserCardNotExistingException.class)
  public ResponseEntity<ErrorDTO> catchUserCardNotExistingException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(404).body(new ErrorDTO("Ismeretlen kártya", 10102));
  }

  @ExceptionHandler(value = NotEnoughBalanceException.class)
  public ResponseEntity<ErrorDTO> catchNotEnoughBalanceException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(403)
        .body(new ErrorDTO("A felhasználónak nincs elegendő pénze hogy megvásárolja a jegyet!", 10101));
  }

  @ExceptionHandler(value = UserAndCardNotMatchingException.class)
  public ResponseEntity<ErrorDTO> catchUserAndCardNotMatchingException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(406).body(new ErrorDTO("Ez a bankkártya nem ehhez a felhasználóhoz tartozik", 10100));
  }

  @ExceptionHandler(value = EventInThePastException.class)
  public ResponseEntity<ErrorDTO> catchEventInThePastException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(406)
        .body(new ErrorDTO("Olyan eseményre ami már elkezdődött nem lehet jegyet eladni!", 20011));
  }

  @ExceptionHandler(value = EventNotFoundException.class)
  public ResponseEntity<ErrorDTO> catchEventNotFoundException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(404).body(new ErrorDTO("Nem létezik ilyen esemény!", 20001));
  }

  @ExceptionHandler(value = SeatReservedException.class)
  public ResponseEntity<ErrorDTO> catchSeatReservedException(Exception ex) {
    log.warn(ex.getClass().getName());
    return ResponseEntity.status(406).body(new ErrorDTO("Már lefoglalt székre nem lehet jegyet eladni!", 20010));
  }

  @ExceptionHandler(value = RuntimeException.class)
  public ResponseEntity<Object> handleUncaughtException(RuntimeException e) {
    log.error("Uncaught " + e.getClass().getName() + "cause:" + e.getCause().toString() + " stacktrace: " +
        Arrays.toString(e.getStackTrace()));
    return ResponseEntity.status(400)
        .body("Unknown error.");
  }
}
