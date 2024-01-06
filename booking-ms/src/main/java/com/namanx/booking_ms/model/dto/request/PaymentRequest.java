package com.namanx.booking_ms.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import static com.namanx.booking_ms.model.constants.Messages.*;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Data
@Validated
public class PaymentRequest {

    @NotNull(message = CLIENT_ID_URGENT)
    Long clientId;

    @NotNull(message = NULL_PRICE)
    @Positive(message = NEGATIVE_PRICE)
    Double amount;

    @NotBlank(message = NULL_PAYMENT_METHOD)
    String paymentMethod;
}
