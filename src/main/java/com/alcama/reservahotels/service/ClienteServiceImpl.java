package com.alcama.reservahotels.service;

import com.alcama.reservahotels.model.Cliente;
import com.alcama.reservahotels.repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService{

    @Autowired
    IClienteRepository repoClient;

    @Override
    public Optional<Cliente> buscarClientePorEmail(String email) {
        return repoClient.buscarClientePorEmail(email);
    }
}
