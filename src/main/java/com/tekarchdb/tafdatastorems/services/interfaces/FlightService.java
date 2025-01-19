package com.tekarchdb.tafdatastorems.services.interfaces;

import com.tekarchdb.tafdatastorems.models.Flights;

import java.util.List;
import java.util.Optional;

public interface FlightService {
    Flights addFlight( Flights flight);

    Optional<Flights> getFlightById(Long flightId);

    List<Flights> getAllFlights();

    Flights updateFlightDetails(Long id, Flights flightDetails);

    void deleteFlight(Long id);
}
