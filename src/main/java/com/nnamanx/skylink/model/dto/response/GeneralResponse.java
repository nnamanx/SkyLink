package com.nnamanx.skylink.model.dto.response;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class GeneralResponse {

     String message;
     HttpStatus httpStatus;
     LocalDate time;

}
