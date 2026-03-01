package com.alcama.reservahotels.service;

import com.alcama.reservahotels.model.Cliente;
import com.alcama.reservahotels.model.Reserva;
import com.alcama.reservahotels.model.dto.ReservaRequestDTO;
import com.alcama.reservahotels.model.dto.ReservaResponserDTO;
import com.alcama.reservahotels.model.dto.ResumenDTO;
import com.alcama.reservahotels.repository.IReservaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
public class ReservaServiceImpl implements IReservaService {

    @Autowired
    IReservaRepository repoReserva;

    @Autowired
    IClienteService serviceCliente;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public Reserva registrarReserva(ReservaRequestDTO dto) throws Exception {
        Cliente cliente = serviceCliente.buscarClientePorEmail(dto.getEmail())
                .orElseThrow(() -> new Exception("El cliente no existe"));

        if (dto.getFechaSalida().isBefore(dto.getFechaEntrada())) {
            throw new Exception("La fecha salida no puede ser anterior a la de entrada");
        }

        Reserva reserva = modelMapper.map(dto, Reserva.class);
        reserva.setCliente(cliente);
        reserva.setConfirmada(false);

        return repoReserva.save(reserva);
    }

    @Transactional
    @Override
    public void eliminarReservas(Integer id) throws Exception {
        repoReserva.findById(id)
                .orElseThrow(() -> new Exception("El cliente no existe"));

        repoReserva.borrarReservas(id);
    }

    @Transactional
    @Override
    public Integer sumarPrecioTotalDeUnCliente(String email) throws Exception {
        serviceCliente.buscarClientePorEmail(email)
                .orElseThrow(() -> new Exception("El cliente no existe"));

        Integer sumaTotal =  repoReserva.sumarPrecioTotalDeUnCliente(email);

        if (sumaTotal == null) {
            throw new Exception("No tiene reservas");
        }

        return sumaTotal;
    }

    @Override
    public List<ReservaResponserDTO> reservasAPartirDeUnaFecha(LocalDate fecha) {
        return repoReserva.reservasAPartirDeUnaFecha(fecha)
                .stream()
                .map(reserva -> modelMapper.map(reserva, ReservaResponserDTO.class))
                .toList();
    }

    @Override
    public ResumenDTO resumen() {
        Integer confirmadas = repoReserva.contarConfirmadas();
        Integer noConfirmadas = repoReserva.contarNoConfirmadas();

        return new ResumenDTO(confirmadas, noConfirmadas);
    }

    @Override
    @Transactional
    public Reserva modificarReservaPorId(Integer id, ReservaRequestDTO dto) throws Exception {
        Reserva reservaExistente = repoReserva.findById(id)
                .orElseThrow(() -> new Exception("Reserva no encontrada"));

        if (dto.getFechaSalida().isBefore(dto.getFechaEntrada())) {
            throw new Exception("La fecha de salida no puede ser anterior a la de entrada");
        }

        reservaExistente.setFechaEntrada(dto.getFechaEntrada());
        reservaExistente.setFechaSalida(dto.getFechaSalida());
        reservaExistente.setPrecioTotal(dto.getPrecioTotal());

        return repoReserva.save(reservaExistente);
    }

}
