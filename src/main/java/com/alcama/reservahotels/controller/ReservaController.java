package com.alcama.reservahotels.controller;

import com.alcama.reservahotels.model.Reserva;
import com.alcama.reservahotels.model.dto.ReservaRequestDTO;
import com.alcama.reservahotels.model.dto.ReservaResponserDTO;
import com.alcama.reservahotels.model.dto.ResumenDTO;
import com.alcama.reservahotels.service.IReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private IReservaService reservaService;

    @PostMapping("/registrar")
    public ResponseEntity<Reserva> insertarReserva(@Valid @RequestBody ReservaRequestDTO dto) {
        try {
            Reserva reserva = reservaService.registrarReserva(dto);
            return new ResponseEntity<>(reserva, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> borrarReservas(@PathVariable Integer id) {
        try {
            reservaService.eliminarReservas(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/conteo")
    public ResponseEntity<Integer> obtenerConteo(@RequestParam String email) {
        try {
            return new ResponseEntity<>(reservaService.sumarPrecioTotalDeUnCliente(email), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/fecha")
    public ResponseEntity<List<ReservaResponserDTO>> obtenerReservasPorFecha(@RequestParam LocalDate fecha) {
        return new ResponseEntity<>(reservaService.reservasAPartirDeUnaFecha(fecha), HttpStatus.OK);
    }

    @GetMapping("/resumen")
    public ResponseEntity<ResumenDTO> resumen() {
        return new ResponseEntity<>(reservaService.resumen(), HttpStatus.OK);
    }

    @PutMapping("/modificar/{id}")
    public ResponseEntity<Reserva> modificarReserva(@PathVariable Integer id, @Valid @RequestBody ReservaRequestDTO dto) {
        try {
            Reserva reservaModificada = reservaService.modificarReservaPorId(id, dto);
            return new ResponseEntity<>(reservaModificada, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
