package com.graphqljava.tutorial.bookDetails;

import lombok.Data;

import java.util.List;

@Data
public class Reservation {
    private List<String> reservationIds;
    public Reservation(List<String> reservationIds) {
        this.reservationIds = reservationIds;
    }
}
