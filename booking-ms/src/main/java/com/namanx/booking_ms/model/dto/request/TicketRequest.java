package com.namanx.booking_ms.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;

import static com.namanx.booking_ms.model.constants.Messages.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Validated
public class TicketRequest {

    @NotBlank(message = CLIENT_ID_URGENT)
    Long clientId;
    @NotBlank(message = FROM_WHERE)
    String from;
    @NotBlank(message = TO_WHERE)
    String to;
    @NotBlank(message = DEPARTURE_DATE_URGENT)
    LocalDateTime departureDateTime;
    LocalDateTime arrivalDateTime;
    Double price;
}
