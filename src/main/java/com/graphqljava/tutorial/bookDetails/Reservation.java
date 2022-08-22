package com.graphqljava.tutorial.bookDetails;

import lombok.Data;

@Data
public class Reservation {
    private String reservationId;
    private String reservationDetail;
    public Reservation(String reservationId, String reservationDetail) {
        this.reservationId = reservationId;
        this.reservationDetail = reservationDetail;
    }
}
