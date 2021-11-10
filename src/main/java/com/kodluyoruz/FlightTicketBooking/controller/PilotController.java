package com.kodluyoruz.FlightTicketBooking.controller;

import com.kodluyoruz.FlightTicketBooking.model.dto.PilotDto;
import com.kodluyoruz.FlightTicketBooking.model.request.CreateUpdatePilotRequest;
import com.kodluyoruz.FlightTicketBooking.service.PilotService;
import com.kodluyoruz.FlightTicketBooking.service.PilotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("pilots")
@RequiredArgsConstructor
public class PilotController {
    
    private final PilotService service;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PilotDto createPilot(@RequestBody CreateUpdatePilotRequest request){
        return service.createPilot(request);
    }
    @GetMapping("{id}")
    public PilotDto getPilot(@PathVariable int id) {
        return service.getPilotById(id);
    }


    @PutMapping("{id}")
    public PilotDto updatePilot(@PathVariable int id, @RequestBody CreateUpdatePilotRequest request){
        return service.updatePilot(id,request);
    }

    @GetMapping
    public List<PilotDto> getPilotList() {
        return service.getPilotList();
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePilot(@PathVariable  int id){
        service.deletePilot(id);
    }
}
