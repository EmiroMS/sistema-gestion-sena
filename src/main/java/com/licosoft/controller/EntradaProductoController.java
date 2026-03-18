package com.licosoft.controller;

import com.licosoft.entity.EntradaProducto;
import com.licosoft.repository.EntradaProductoRepository;
import com.licosoft.service.EntradaProductoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entradas")
@CrossOrigin(origins = "*")
public class EntradaProductoController {

    private final EntradaProductoService service;
    private final EntradaProductoRepository repository;

    public EntradaProductoController(
            EntradaProductoService service,
            EntradaProductoRepository repository) {

        this.service = service;
        this.repository = repository;
    }

    // =========================
    // REGISTRAR ENTRADA
    // =========================

    @PostMapping
    public EntradaProducto registrar(@RequestBody EntradaProducto entrada) {
        return service.registrarEntrada(entrada);
    }

    // =========================
    // HISTORIAL DE ENTRADAS
    // =========================

    @GetMapping
    public List<EntradaProducto> listar(){
        return repository.findAll();
    }
}