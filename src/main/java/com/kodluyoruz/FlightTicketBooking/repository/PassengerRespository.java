package com.kodluyoruz.FlightTicketBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kodluyoruz.FlightTicketBooking.model.entity.Passenger;

public interface PassengerRespository extends JpaRepository<Passenger,Integer> {

}
