package com.namanx.booking_ms.model.entity;

import com.namanx.booking_ms.model.enums.RoomType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class HotelReservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long reservation_id;
    String hotelName;
    @Enumerated(EnumType.STRING)
    RoomType roomType;
    LocalDateTime checkInDateTime;
    LocalDateTime checkOutDateTime;
    Double price;

    Long client_id;

    @OneToMany(mappedBy = "hotelReservation")
    private List<Payment> payments;

}
