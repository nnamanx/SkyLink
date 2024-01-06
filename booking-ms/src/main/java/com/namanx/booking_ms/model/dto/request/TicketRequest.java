package com.namanx.booking_ms.model.dto.request;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @Future(message = INVALID_DEPARTURE_DATE)
    LocalDateTime departureDateTime;
    @Future(message = INVALID_ARRIVAL_DATE)
    LocalDateTime arrivalDateTime;
    @NotNull(message = NULL_PRICE)
    @Positive(message = NEGATIVE_PRICE)
    Double price;


}
