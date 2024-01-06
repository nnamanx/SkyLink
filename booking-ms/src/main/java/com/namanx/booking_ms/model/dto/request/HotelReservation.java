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
public class HotelReservation {

    @NotNull(message = CLIENT_ID_URGENT)
    Long clientId;

    @NotBlank(message = BLANK_HOTEL_NAME)
    String hotelName;

    @NotBlank(message = BLANK_ROOM_TYPE)
    String roomType;

    @Future(message = INVALID_CHECK_IN_DATE)
    LocalDateTime checkInDateTime;

    @Future(message = INVALID_CHECK_OUT_DATE)
    LocalDateTime checkOutDateTime;

    @NotNull(message = NULL_PRICE)
    @Positive(message = NEGATIVE_PRICE)
    Double price;

}
