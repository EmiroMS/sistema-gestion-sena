package com.licosoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.licosoft.entity.Producto;
import com.licosoft.service.ProductoService;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
//@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        return ResponseEntity.ok(productoService.crearProducto(producto));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(productoService.listarProductos());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(productoService.obtenerPorId(id));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizar(
            @PathVariable Long id,
            @RequestBody Producto producto
    ) {
        return ResponseEntity.ok(productoService.actualizarProducto(id, producto));
    }

    // DELETE (lógico)
    @DeleteMapping("/{id}")
    public ResponseEntity<String> eliminar(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return ResponseEntity.ok("Producto desactivado correctamente");
    }

}

