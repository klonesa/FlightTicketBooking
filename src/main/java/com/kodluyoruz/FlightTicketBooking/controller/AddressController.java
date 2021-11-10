package com.kodluyoruz.FlightTicketBooking.controller;

import com.kodluyoruz.FlightTicketBooking.model.dto.AddressDto;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdateAddressRequest;
import com.kodluyoruz.FlightTicketBooking.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("addresses")
@RequiredArgsConstructor
public class AddressController {
    private final AddressService service;

    @GetMapping("{id}")
    public AddressDto getAddress(@PathVariable int id) {
        return service.getAddressById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AddressDto createAddress(@RequestBody CreateUpdateAddressRequest request){
        return service.createAddress(request);
    }

    @PutMapping("{id}")
    public AddressDto updateAddress(@PathVariable int id, @RequestBody CreateUpdateAddressRequest request){
        return service.updateAddress(id,request);
    }

    @GetMapping
    public List<AddressDto> getAddressList() {
        return service.getAddressList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAddress(@PathVariable  int id){
        service.deleteAddress(id);
    }
}
