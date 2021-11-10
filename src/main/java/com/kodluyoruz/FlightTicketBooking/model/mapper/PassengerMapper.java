package com.kodluyoruz.FlightTicketBooking.model.mapper;

import com.kodluyoruz.FlightTicketBooking.model.dto.PassengerDto;
import com.kodluyoruz.FlightTicketBooking.model.entity.Passenger;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdatePassengerRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface PassengerMapper {
    PassengerMapper PASSENGER_MAPPER= Mappers.getMapper(PassengerMapper.class);

    PassengerDto toPassengerDto(Passenger passenger);

    List<PassengerDto> toPassengerDtoList(List<Passenger> passengerList);

    Passenger createPassenger(CreateUpdatePassengerRequest request);

    void updatePassenger(@MappingTarget Passenger passenger,CreateUpdatePassengerRequest request);

}
