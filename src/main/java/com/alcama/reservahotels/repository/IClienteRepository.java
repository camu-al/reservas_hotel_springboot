package com.alcama.reservahotels.repository;

import com.alcama.reservahotels.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    Optional<Cliente> buscarClientePorEmail(@Param("email") String email);

}
