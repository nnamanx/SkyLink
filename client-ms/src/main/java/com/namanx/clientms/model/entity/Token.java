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
public class Token {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String token;
    LocalDateTime expirationDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    Client client;

}
