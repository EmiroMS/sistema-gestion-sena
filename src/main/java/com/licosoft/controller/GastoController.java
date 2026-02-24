package com.licosoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.licosoft.entity.Gasto;
import com.licosoft.service.GastoService;

@RestController
@RequestMapping("/api/gastos")
public class GastoController {

    @Autowired
    private GastoService gastoService;

    @PostMapping
    public ResponseEntity<Gasto> crear(@RequestBody Gasto gasto) {
        return ResponseEntity.ok(gastoService.crear(gasto));
    }

    @GetMapping
    public ResponseEntity<List<Gasto>> listar() {
        return ResponseEntity.ok(gastoService.listar());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Gasto> editar(
            @PathVariable Long id,
            @RequestBody Gasto gasto) {

        return ResponseEntity.ok(gastoService.editar(id, gasto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {

        gastoService.eliminar(id);
        return ResponseEntity.ok("Gasto desactivado correctamente");
    }
}
