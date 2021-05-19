package com.ticketservice.core.service;

import com.ticketservice.core.api.ApiService;
import com.ticketservice.core.exception.EventInThePastException;
import com.ticketservice.core.exception.EventNotFoundException;
import com.ticketservice.core.exception.NotEnoughBalanceException;
import com.ticketservice.core.exception.SeatNotFoundException;
import com.ticketservice.core.exception.SeatReservedException;
import com.ticketservice.core.exception.TokenInvalidException;
import com.ticketservice.core.exception.UserAndCardNotMatchingException;
import com.ticketservice.core.exception.UserCardException;
import com.ticketservice.core.exception.UserCardNotExistingException;
import com.ticketservice.core.model.Event;
import com.ticketservice.core.model.EventsDTO;
import com.ticketservice.core.model.PaymentDTO;
import com.ticketservice.core.model.ReservationDTO;
import com.ticketservice.core.model.ReservationRequestDTO;
import com.ticketservice.core.model.Seat;
import com.ticketservice.core.model.SeatsDTO;
import com.ticketservice.core.model.UserBankCard;
import com.ticketservice.core.model.UserToken;
import com.ticketservice.core.repo.CardRepository;
import com.ticketservice.core.repo.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

  @Autowired
  private CardRepository cardRepository;

  @Autowired
  private TokenRepository tokenRepository;

  @Autowired
  private ApiService apiService;

  public long getUserIdFromToken(String token) {
    byte[] decodedBytes = Base64.getDecoder().decode(token);
    String decodedString = new String(decodedBytes);
    String[] decodedStringArr = decodedString.split("&");
    return Long.parseLong(decodedStringArr[1]);
  }

  public boolean isTokenValid(String token) throws TokenInvalidException {
    Optional<UserToken> usertoken = tokenRepository.findById(token);
    return usertoken.isPresent();
  }

  private Seat checkSeatBeforePayment(PaymentDTO paymentDTO)
      throws IOException, EventNotFoundException, SeatNotFoundException, EventInThePastException,
      SeatReservedException {

    EventsDTO eventsDTO = apiService.getEvents();
    Event event = eventsDTO.getData().stream().filter(e -> e.getId() == paymentDTO.getEventId()).findFirst()
        .orElseThrow(() -> new EventNotFoundException());

    if (System.currentTimeMillis() > event.getStartTimeStamp()) {
      throw new EventInThePastException();
    }

    SeatsDTO seatsDTO = apiService.getEvent(paymentDTO.getEventId());
    List<Seat> seats = seatsDTO.getData().getSeats();
    Seat seat = seats.stream().filter(s -> s.getSeatId().equals(paymentDTO.getSeatId())).findFirst()
        .orElseThrow(() -> new SeatNotFoundException());

    if (seat.isReserved()) {
      throw new SeatReservedException();
    }

    return seat;
  }

  public ReservationDTO payForTicket(String token, PaymentDTO paymentDTO)
      throws UserCardException, IOException, EventNotFoundException, EventInThePastException, SeatNotFoundException,
      SeatReservedException {

    Seat checkedSeat = checkSeatBeforePayment(paymentDTO);

    UserBankCard card = cardRepository.findById(paymentDTO.getCardId()).orElseThrow(UserCardNotExistingException::new);
    checkIfCardBelongsToUser(token, card.getUser().getUserId());

    ReservationDTO reservationDTO;
    if (checkedSeat.getPrice() <= card.getAmount()) {
      reservationDTO = apiService.reserve(new ReservationRequestDTO(paymentDTO.getEventId(), paymentDTO.getSeatId()));
    } else {
      throw new NotEnoughBalanceException();
    }

    deductAmountFromCard(card, checkedSeat.getPrice());

    return reservationDTO;
  }

  private void checkIfCardBelongsToUser(String token, long userId) throws UserAndCardNotMatchingException {
    if (getUserIdFromToken(token) != userId) {
      throw new UserAndCardNotMatchingException();
    }
  }

  private void deductAmountFromCard(UserBankCard card, Integer amount) {
    card.setAmount(card.getAmount() - amount);
    cardRepository.save(card);
  }
}

