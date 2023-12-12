package com.namanx.clientms.model.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfirmationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String confirmationToken;
    LocalDateTime expirationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Client client;
}
