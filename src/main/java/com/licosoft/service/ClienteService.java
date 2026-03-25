package com.licosoft.service;

import com.licosoft.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface ClienteService {

    List<Cliente> listar();

    List<Cliente> buscarPorNombre(String nombre);

    Cliente guardar(Cliente cliente);

    Optional<Cliente> buscarPorNombreExacto(String nombre);

}