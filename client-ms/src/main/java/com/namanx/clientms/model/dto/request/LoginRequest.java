package com.namanx.clientms.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.namanx.clientms.model.constant.Messages.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class LoginRequest {

    @NotBlank(message = ENTER_USER_NAME)
    String username;

    @NotBlank(message = ENTER_PASSWORD)
    String password;
}
