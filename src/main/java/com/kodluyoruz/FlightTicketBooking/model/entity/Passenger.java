package com.kodluyoruz.FlightTicketBooking.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "passengers")
@SuperBuilder
public class Passenger extends BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @Column(nullable = false)
    private String passengerFirstName;

    @Column(nullable = false)
    private String passengerLastName;

    @Column(nullable = false,unique = true)
    private String passengerIdentityNumber;

    @Column(unique = true,nullable = false)
    private String passengerEmail;

    @Column(unique = true,nullable = false)
    private String passengerPhoneNumber;

    @ManyToMany(mappedBy = "passengers",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Address> addresses=new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY,mappedBy = "passenger")
    private List<TicketBooking> ticketBooking;

}
