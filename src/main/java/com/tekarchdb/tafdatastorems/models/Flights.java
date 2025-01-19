package com.tekarchdb.tafdatastorems.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flights {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column( name = "flight_number",nullable = false, unique = true)
    private String flight_number;
    @Column( name = "airport_code",nullable = false)
    private String airport_code;
    @Column
    private String departure;
    @Column
    private String arrival;
    @Column( name = "departure_time")
    private LocalTime departure_time;
    @Column( name = "arrival_time")
    private LocalTime arrival_time;
    @Column
    private double price;
    @Column( name = "available_seats")
    private int available_seats;


    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDate createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDate updatedAt;
}
