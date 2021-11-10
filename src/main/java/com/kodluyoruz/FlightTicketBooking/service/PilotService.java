package com.kodluyoruz.FlightTicketBooking.service;

import com.kodluyoruz.FlightTicketBooking.exception.BussinesException;
import com.kodluyoruz.FlightTicketBooking.exception.NotFoundException;
import com.kodluyoruz.FlightTicketBooking.model.dto.PilotDto;
import com.kodluyoruz.FlightTicketBooking.model.entity.Pilot;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdatePilotRequest;
import com.kodluyoruz.FlightTicketBooking.repository.PilotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.kodluyoruz.FlightTicketBooking.model.mapper.PilotMapper.PILOT_MAPPER;
@Service
@RequiredArgsConstructor
public class PilotService {
    private final PilotRepository repository;
    private final  AddressService addressService;
    public PilotDto createPilot(CreateUpdatePilotRequest request){
        Pilot pilot=PILOT_MAPPER.createPilot(request);
        pilot.getAddresses().add(addressService.toAddress(request.getAddressId()));
        return PILOT_MAPPER.toPilotDto(repository.save(pilot));
    }
    public PilotDto updatePilot(int id, CreateUpdatePilotRequest request){
        Pilot pilot=repository.findById(id).orElseThrow(()->new NotFoundException("Pilot   not found."));
        PILOT_MAPPER.updatePilot(pilot,request);
        Pilot updatedpilot=repository.save(pilot);
        return PILOT_MAPPER.toPilotDto(updatedpilot);
    }
    public PilotDto getPilotById(int id){
        return PILOT_MAPPER.toPilotDto(repository.findById(id).orElseThrow(()-> new NotFoundException("Pilot   not found.")));
    }
    public List<PilotDto> getPilotList(){
        return  PILOT_MAPPER.toPilotDtoList(repository.findAll());
    }

    public void deletePilot(int id){
        repository.deleteById(id);
    }

    public void setAvailabilty(int id){
        repository.setAvailable(id,false);
    }
}
