package com.tekarchdb.tafdatastorems.repositories;

import com.tekarchdb.tafdatastorems.models.Bookings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Bookings, Long> {
}
