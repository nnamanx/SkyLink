package com.nnamanx.skylink.model.dto.request;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import static com.nnamanx.skylink.model.constant.Message.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserRequest {

    String name;

    @NotBlank(message = EMAIL_IS_URGENT)
    @Email(message = EMAIL_IS_NOT_VALID)
    String email;

    @NotBlank(message = USERNAME_IS_URGENT)
    String username;

    @NotBlank(message = PASSWORD_IS_NOT_VALID)
    @Size(min = 8, message = PASSWORD_REGEX)
    String password;

    String phoneNumber;

    @NotBlank(message = PASSPORT_FIN_IS_URGENT)
    String passportFin;

    @NotBlank(message = PASSPORT_SERIA_IS_URGENT)
    String passportSeria;
}
