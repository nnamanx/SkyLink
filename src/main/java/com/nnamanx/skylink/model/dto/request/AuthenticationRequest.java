package com.nnamanx.skylink.model.dto.request;

import static com.nnamanx.skylink.model.constant.Message.*;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class AuthenticationRequest {

    @NotBlank(message = EMAIL_IS_URGENT)
    @Email
    String email;

    @NotBlank(message = PASSWORD_IS_URGENT)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@#$%])[A-Za-z\\d@#$%]{8,}$", message = PASSWORD_REGEX)
    String password;
}
