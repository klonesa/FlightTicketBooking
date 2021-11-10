package com.kodluyoruz.FlightTicketBooking.model.request;

import com.kodluyoruz.FlightTicketBooking.model.dto.AddressDto;
import com.kodluyoruz.FlightTicketBooking.model.entity.Address;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateUpdatePassengerRequest {
    private String passengerFirstName;

    private String passengerLastName;

    private String passengerIdentityNumber;

    private String passengerEmail;

    private String passengerPhoneNumber;

    private int addressId;


}
