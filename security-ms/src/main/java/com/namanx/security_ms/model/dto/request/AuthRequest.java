package com.namanx.security_ms.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import static com.namanx.security_ms.model.constants.Messages.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthRequest {

    @NotBlank(message = EMAIL_IS_MANDATORY)
    @Email
    String email;

    @NotBlank(message = PASSWORD_IS_MANDATORY)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%])[A-Za-z\\d@#$%]{8,}$", message = PASSWORD_REGEX)
    String password;
}
