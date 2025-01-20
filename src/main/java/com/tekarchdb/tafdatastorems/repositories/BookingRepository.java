package com.tekarchdb.tafdatastorems.repositories;

import com.tekarchdb.tafdatastorems.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
    // Query to find bookings by user ID
    List<Bookings> findByUsersId(Long userId);
}
