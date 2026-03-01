package com.alcama.reservahotels.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "reserva")
@AllArgsConstructor
@Getter
@Setter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fecha_entrada")
    private LocalDate fechaEntrada;

    @Column(name = "fecha_salida")
    private LocalDate fechaSalida;

    @Column(name = "precio_total")
    private Integer precioTotal;

    @Column
    private boolean confirmada;

    @ManyToOne
    @JoinColumn(name = "id_cliente", nullable = false)
    private Cliente cliente;

    public Reserva() {
    }

}
