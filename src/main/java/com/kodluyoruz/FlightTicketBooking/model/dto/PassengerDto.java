package com.kodluyoruz.FlightTicketBooking.model.dto;


import com.kodluyoruz.FlightTicketBooking.model.entity.Address;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdateAddressRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PassengerDto {

    private int id;

    private String passengerFirstName;

    private String passengerLastName;

    private String passengerIdentityNumber;

    private String passengerEmail;

    private String passengerPhoneNumber;

    private Set<AddressDto> addresses=new HashSet<>();
}
