package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.licosoft.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository
        extends JpaRepository<Cliente,Long>{

    Optional<Cliente> findByNombre(String nombre);

    // ✅ BUSQUEDA AUTOCOMPLETE
    List<Cliente> findByNombreContainingIgnoreCase(
            String nombre);

}