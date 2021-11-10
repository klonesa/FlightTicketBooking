package com.kodluyoruz.FlightTicketBooking.controller;

import com.kodluyoruz.FlightTicketBooking.model.dto.PassengerDto;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdatePassengerRequest;
import com.kodluyoruz.FlightTicketBooking.service.PassengerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("passengers")
@RequiredArgsConstructor
public class PassengerController {
    private final PassengerService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PassengerDto createPassenger(@RequestBody CreateUpdatePassengerRequest request){
        return service.createPassenger(request);
    }
    @GetMapping("{id}")
    public PassengerDto getPassenger(@PathVariable int id) {
        return service.getPassengerById(id);
    }


    @PutMapping("{id}")
    public PassengerDto updatePassenger(@PathVariable int id, @RequestBody CreateUpdatePassengerRequest request){
        return service.updatePassenger(id,request);
    }

    @GetMapping
    public List<PassengerDto> getPassengerList() {
        return service.getPassengerList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePassenger(@PathVariable  int id){
        service.deletePassenger(id);
    }


}
