package com.tekarchdb.tafdatastorems.services;


import com.tekarchdb.tafdatastorems.models.Flights;
import com.tekarchdb.tafdatastorems.models.Users;
import com.tekarchdb.tafdatastorems.repositories.FlightRepository;
import com.tekarchdb.tafdatastorems.services.interfaces.FlightService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FlightServiceImpl implements FlightService {

    private final FlightRepository flightRepository;

    @Override
    public Flights addFlight(Flights flight) {
        return flightRepository.save(flight);
    }

    @Override
    public Optional<Flights> getFlightById(Long flightId) {
         return flightRepository.findById(flightId);
    }

    @Override
    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    @Override
    public Flights updateFlightDetails(Long flightId, Flights flightDetails) {
        Optional<Flights> optionalFlightDetails = flightRepository.findById(flightId);

        if (optionalFlightDetails.isPresent()) {
            return flightRepository.save(flightDetails);

        } else {
            return null;
        }
    }

    @Override
    public void deleteFlight(Long flightId) {
        flightRepository.deleteById(flightId);
    }
}
