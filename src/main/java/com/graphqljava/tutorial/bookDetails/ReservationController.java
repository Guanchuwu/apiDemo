package com.graphqljava.tutorial.bookDetails;

import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.stream.Collectors;
@Slf4j
@Controller

/*
query {
  getMatchedReservation(items: [{partnerId:"p1", confirmationNumber:"c1"}, {partnerId:"p2", confirmationNumber:"c2"}]){
    reservationIds
  }
}
 */

public class ReservationController {
    @QueryMapping
    public List<Reservation> getMatchedReservation(@Argument List<Item> items) {
        return items.stream()
                .map(item -> new Reservation(item.getPartnerId()+item.getConfirmationNumber(), "reservationDetail"))
                .collect(Collectors.toList());
    }
}
