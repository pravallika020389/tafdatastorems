package com.tekarchdb.tafdatastorems.controllers;

import com.tekarchdb.tafdatastorems.models.Bookings;
import com.tekarchdb.tafdatastorems.models.BookingsDTO;
import com.tekarchdb.tafdatastorems.models.Flights;
import com.tekarchdb.tafdatastorems.models.Users;
import com.tekarchdb.tafdatastorems.services.BookingServiceImpl;
import com.tekarchdb.tafdatastorems.services.FlightServiceImpl;
import com.tekarchdb.tafdatastorems.services.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/datastore")
public class DataStoreController {

    private final UserServiceImpl userService;
    private final FlightServiceImpl flightService;
    private final BookingServiceImpl bookingService;

/*=================================================USER=================================================*/

    @PostMapping("/users/register")
    public Users registerUser(@RequestBody Users user){
        return userService.registerUser(user);
    }

    @GetMapping("/users/{userId}")
    public Optional<Users> getUserById(@PathVariable("userId") Long userId) {
       return userService.getUserById(userId);
    }

    @PutMapping("/users/{userId}")
    public ResponseEntity<Object> updateUser(@PathVariable("userId") Long id, @RequestBody Users userDetails) {
        Users updatedUser = userService.updateUser(id, userDetails);

        if (updatedUser != null) {
            return ResponseEntity.ok(updatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found");
        }
    }

    /*================================================FLight==================================================*/


    @PostMapping("/flights/add")
    public Flights addFlight(@RequestBody Flights flight){
        return flightService.addFlight(flight);
    }

    @GetMapping("/flights/{flightId}")
    public Optional<Flights> getFlightById(@PathVariable("flightId") Long flightId) {

        return flightService.getFlightById(flightId);
    }

    @GetMapping("/flights/allflights")
    public List<Flights> getAllFlights() {

        return flightService.getAllFlights();
    }

    @PutMapping("/flights/{flightId}")
    public ResponseEntity<Object> updateUser(@PathVariable("flightId") Long id, @RequestBody Flights flightDetails) {
        Flights updatedFlight = flightService.updateFlightDetails(id, flightDetails);

        if (updatedFlight != null) {
            return ResponseEntity.ok(updatedFlight);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Unable to update Flight details ");
        }
    }

    @DeleteMapping("/flights/{flightId}")
    public void deleteFlight(@PathVariable("flightId") Long id) {
            flightService.deleteFlight(id);
    }

    /*================================================Booking==================================================*/

    @PostMapping("/bookings/book")
    public Bookings bookFlight(@RequestBody Bookings booking){
        return bookingService.bookFlight(booking);
    }
    @GetMapping("/bookings/{bookingId}")
    public Optional<Bookings> getBookedDetailsById(@PathVariable("bookingId") Long bookingId) {

        return bookingService.getBookedDetailsById(bookingId);
    }

    @GetMapping("bookings/users/{userId}")
    public List<Bookings> getAllBookedDetailsByUserId(@PathVariable("userId") Long userId) {

        return bookingService.getBookedDetailsByUserId(userId);
    }


    @PutMapping("/bookings/{bookingId}")
    public void updateUser(@PathVariable("bookingId") Long id, @RequestBody Bookings bookedDetails) {
        bookingService.updateBookingDetails(id, bookedDetails);

    }

    @ExceptionHandler
    public ResponseEntity<?> respondWithError(Exception e){
        return new ResponseEntity<>("Exception Occurred. More Info :"
                + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

}
