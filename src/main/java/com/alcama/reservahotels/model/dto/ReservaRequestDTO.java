package com.alcama.reservahotels.model.dto;

import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ReservaRequestDTO {

    @Setter
    private LocalDate fechaEntrada;
    private LocalDate fechaSalida;

    @Max(250)
    @Min(25)
    private Integer precioTotal;

    @Email
    private String email;

    public ReservaRequestDTO() {

    }

}
