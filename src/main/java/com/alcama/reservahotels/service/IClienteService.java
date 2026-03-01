package com.alcama.reservahotels.service;

import com.alcama.reservahotels.model.Cliente;

import java.util.Optional;

public interface IClienteService {

    Optional<Cliente> buscarClientePorEmail(String email);

}
