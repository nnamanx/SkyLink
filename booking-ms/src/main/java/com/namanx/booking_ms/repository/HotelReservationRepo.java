package com.namanx.booking_ms.repository;

import com.namanx.booking_ms.model.entity.HotelReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelReservationRepo extends JpaRepository<HotelReservation, Long> {
}
