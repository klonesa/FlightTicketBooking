package com.kodluyoruz.FlightTicketBooking.service;

import com.kodluyoruz.FlightTicketBooking.exception.NotFoundException;
import com.kodluyoruz.FlightTicketBooking.model.dto.PassengerDto;
import com.kodluyoruz.FlightTicketBooking.model.entity.Address;
import com.kodluyoruz.FlightTicketBooking.model.entity.Passenger;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdatePassengerRequest;
import com.kodluyoruz.FlightTicketBooking.repository.AddressRepository;
import com.kodluyoruz.FlightTicketBooking.repository.PassengerRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.FlightTicketBooking.model.mapper.PassengerMapper.PASSENGER_MAPPER;

@Service
@RequiredArgsConstructor
public class PassengerService {
    private final PassengerRespository repository;
    private final AddressService addressService;

    public PassengerDto createPassenger(CreateUpdatePassengerRequest request){
        Passenger passenger=PASSENGER_MAPPER.createPassenger(request);
        passenger.getAddresses().add(addressService.toAddress(request.getAddressId()));
        return PASSENGER_MAPPER.toPassengerDto(repository.save(passenger));
    }
    public PassengerDto updatePassenger(int id, CreateUpdatePassengerRequest request){
        Passenger passenger=repository.findById(id).orElseThrow(()->new NotFoundException("Passenger not found."));
        PASSENGER_MAPPER.updatePassenger(passenger,request);
        Passenger updatedPassenger=repository.save(passenger);
        return PASSENGER_MAPPER.toPassengerDto(updatedPassenger);
    }
    public PassengerDto getPassengerById(int id){
        return PASSENGER_MAPPER.toPassengerDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Passenger not found.")));
    }

    public List<PassengerDto> getPassengerList(){
        return  PASSENGER_MAPPER.toPassengerDtoList(repository.findAll());
    }

    public void deletePassenger(int id){
        repository.deleteById(id);
    }



}
