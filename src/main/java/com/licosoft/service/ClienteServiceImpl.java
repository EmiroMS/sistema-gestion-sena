package com.licosoft.service;

import com.licosoft.entity.Cliente;
import com.licosoft.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl
        implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> listar(){

        return clienteRepository.findAll();

    }


    @Override
    public List<Cliente> buscarPorNombre(
            String nombre){

        return clienteRepository
                .findByNombreContainingIgnoreCase(
                        nombre);

    }


    @Override
    public Cliente guardar(
            Cliente cliente){

        return clienteRepository.save(cliente);

    }


    @Override
    public Optional<Cliente>
    buscarPorNombreExacto(
            String nombre){

        return clienteRepository
                .findByNombre(nombre);

    }

}