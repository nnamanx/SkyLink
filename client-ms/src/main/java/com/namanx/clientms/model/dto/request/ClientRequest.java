package com.namanx.clientms.model.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static com.namanx.clientms.model.constant.Constants.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ClientRequest {

    @NotBlank(message = ENTER_USER_NAME)
    String username;

    @NotBlank(message = ENTER_EMAIL)
    @Email(message = INVALID_EMAIL)
    String email;

    @NotBlank(message = ENTER_PASSWORD)
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\\\d).{8,}$",
            message = INVALID_PASSWORD)
    String password;

    @NotBlank(message = ENTER_PHONE_NUMBER)
    @Pattern(regexp = "^[+\\d][\\d\\s()-]*$", message = "Invalid phone number format")
    String phoneNumber;

    String fin;
    String serialNumber;

    @Past(message = INVALID_BIRTHDATE) // whether the date is in the past
    LocalDateTime birthdate;

}
