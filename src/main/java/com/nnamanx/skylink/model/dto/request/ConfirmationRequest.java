package com.nnamanx.skylink.model.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;

import static com.nnamanx.skylink.model.constant.Message.TOKEN_IS_URGENT;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ConfirmationRequest {

    @NotBlank(message = TOKEN_IS_URGENT)
    String token;
}
