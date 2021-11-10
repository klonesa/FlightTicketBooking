package com.kodluyoruz.FlightTicketBooking.controller;

import com.kodluyoruz.FlightTicketBooking.model.dto.TicketPriceDto;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdateTicketPriceRequest;
import com.kodluyoruz.FlightTicketBooking.service.TicketPriceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("ticketprices")
@RequiredArgsConstructor
public class TicketPriceController {
    private final TicketPriceService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TicketPriceDto createTicketPrice(@RequestBody CreateUpdateTicketPriceRequest request){
        return service.createTicketPrice(request);
    }
    @GetMapping("{id}")
    public TicketPriceDto getTicketPrice(@PathVariable int id) {
        return service.getTicketPriceById(id);
    }


    @PutMapping("{id}")
    public TicketPriceDto updateTicketPrice(@PathVariable int id, @RequestBody CreateUpdateTicketPriceRequest request){
        return service.updateTicketPrice(id,request);
    }

    @GetMapping
    public List<TicketPriceDto> getTicketPriceList() {
        return service.getTicketPriceList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTicketPrice(@PathVariable  int id){
        service.deleteTicketPrice(id);
    }
}
