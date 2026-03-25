package com.licosoft.controller;

import com.licosoft.entity.Cliente;
import com.licosoft.service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")

@CrossOrigin("*")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    // LISTAR
    @GetMapping
    public List<Cliente> listar(){

        return clienteService.listar();

    }


    // BUSCAR AUTOCOMPLETE
    @GetMapping("/buscar")
    public List<Cliente> buscar(

            @RequestParam String nombre){

        return clienteService
                .buscarPorNombre(nombre);

    }


    // CREAR CLIENTE
    @PostMapping
    public Cliente guardar(

            @RequestBody Cliente cliente){

        return clienteService
                .guardar(cliente);

    }

}