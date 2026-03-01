package com.alcama.reservahotels.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
public class ReservaResponserDTO {

    private String nombre;
    private LocalDate fechaEntrada;
    private Integer precioTotal;

    public ReservaResponserDTO() {
    }

}
