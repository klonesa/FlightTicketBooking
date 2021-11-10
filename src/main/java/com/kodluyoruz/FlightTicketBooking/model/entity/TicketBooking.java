package com.kodluyoruz.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ticket_bookings")
@SuperBuilder
public class TicketBooking extends BaseEntity{

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "passenger_id")
    private Integer passengerId;

    @Column(name = "flight_id")
    private Integer flightId;

    @Column
    private Integer numberOfTicket;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "flight_id",insertable = false,updatable = false,nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passenger_id",insertable = false,updatable = false,nullable = false)
    private Passenger passenger;

    @Column
    private Double totalPaidPrice;


}
