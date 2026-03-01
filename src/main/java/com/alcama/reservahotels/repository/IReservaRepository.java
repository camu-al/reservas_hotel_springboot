package com.alcama.reservahotels.repository;

import com.alcama.reservahotels.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IReservaRepository  extends JpaRepository<Reserva, Integer> {

    @Modifying
    @Query("DELETE FROM Reserva r WHERE r.cliente.id = :id")
    void borrarReservas(@Param("id") Integer id);

    @Query("SELECT SUM (r.precioTotal) FROM Reserva r WHERE r.cliente.email = :email")
    Integer sumarPrecioTotalDeUnCliente(@Param("email") String email);

    @Query("SELECT r FROM Reserva r WHERE r.fechaEntrada >= :fecha")
    List<Reserva> reservasAPartirDeUnaFecha(@Param("fecha") LocalDate fecha);

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.confirmada = true ")
    Integer contarConfirmadas();

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.confirmada = false ")
    Integer contarNoConfirmadas();

}
