package com.namanx.booking_ms.model.entity;

import com.namanx.booking_ms.model.enums.PaymentMethod;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long payment_id;
    Double amount;
    LocalDate paymentDate;
    @Enumerated(EnumType.STRING)
    PaymentMethod paymentMethod;
    Boolean status;

    Long client_id;

    @ManyToOne
    @JoinColumn(name = "id", referencedColumnName = "id")
    Ticket ticket;

    @ManyToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservation_Id")
    HotelReservation hotelReservation;

}
