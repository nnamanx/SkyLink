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
    Long id;
    Double amount;
    LocalDate paymentDate;
    PaymentMethod paymentMethod;
    Boolean status;

    Long client_id;

    @ManyToOne
    @JoinColumn(name = "ticket_id", referencedColumnName = "ticketId")
    Ticket ticket;

    @OneToOne
    @JoinColumn(name = "reservation_id", referencedColumnName = "reservationId")
    HotelReservation hotelReservation;
}
