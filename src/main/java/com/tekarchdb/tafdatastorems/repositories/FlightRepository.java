package com.tekarchdb.tafdatastorems.repositories;

import com.tekarchdb.tafdatastorems.models.Flights;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flights, Long> {
}
