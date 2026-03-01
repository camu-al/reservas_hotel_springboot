package com.alcama.reservahotels.service;

import com.alcama.reservahotels.model.Reserva;
import com.alcama.reservahotels.model.dto.ReservaRequestDTO;
import com.alcama.reservahotels.model.dto.ReservaResponserDTO;
import com.alcama.reservahotels.model.dto.ResumenDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IReservaService {

    Reserva registrarReserva(ReservaRequestDTO dto) throws Exception;
    void eliminarReservas(Integer id) throws Exception;
    Integer sumarPrecioTotalDeUnCliente(String email) throws Exception;
    List<ReservaResponserDTO> reservasAPartirDeUnaFecha(LocalDate fecha);
    ResumenDTO resumen();
    Reserva modificarReservaPorId(Integer id, ReservaRequestDTO dto) throws Exception;
}
