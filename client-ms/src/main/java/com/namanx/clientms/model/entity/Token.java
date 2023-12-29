package com.namanx.clientms.model.entity;

import com.namanx.clientms.model.enums.TokenType;
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

    @Column(nullable = false)
    TokenType tokenType; // "ACCESS" or "REFRESH"

    @Column(nullable = false)
    LocalDateTime expirationDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    Client client;

}
