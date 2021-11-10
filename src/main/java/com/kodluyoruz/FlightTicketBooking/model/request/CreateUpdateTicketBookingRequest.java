package com.kodluyoruz.FlightTicketBooking.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdateTicketBookingRequest {
    private int passengerId;

    private int flightId;

    private int numberOfTicket;
}
