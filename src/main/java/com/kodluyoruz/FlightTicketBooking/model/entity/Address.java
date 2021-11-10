package com.kodluyoruz.FlightTicketBooking.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "addresses")
@SuperBuilder

public class Address extends BaseEntity{
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(name = "city_id")
    private Integer cityId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id",insertable = false,updatable = false,nullable = false)
    private City city;

    @Column(columnDefinition="Text")
    private String address;

    @Column(nullable = false)
    private String addressRegion;

    @Column (nullable = false)
    private String addressPostalcode;


    @ManyToMany
    @JoinTable(
            name = "passenger_address",
            joinColumns=@JoinColumn(name = "passenger_id"),
            inverseJoinColumns=@JoinColumn(name = "address_id"))
    private Set<Passenger> passengers=new HashSet<>();

    @ManyToMany
    @JoinTable(
            name = "pilot_address",
            joinColumns=@JoinColumn(name = "pilot_id"),
            inverseJoinColumns=@JoinColumn(name = "address_id"))
    private Set<Pilot> pilots=new HashSet<>();


}
