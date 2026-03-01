package com.alcama.reservahotels.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ResumenDTO {

    private Integer confirmadas;
    private Integer noConfirmadas;

    public ResumenDTO() {
    }

}
