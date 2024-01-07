package com.namanx.booking_ms.model.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String fullName;
    String from;
    String to;
    LocalDateTime departureDateTime;
    LocalDateTime arrivalDateTime;
    Double price;

    Long flight_id;
    Long client_id;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL)
    List<Payment> payments;

}
