package com.licosoft.service;

import org.springframework.stereotype.Service;

import com.licosoft.entity.Producto;
import com.licosoft.repository.ProductoRepository;

import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        producto.setActivo(true);
        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> listarProductos() {
        return productoRepository.findByActivoTrue();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        return productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);

        existente.setNombre(producto.getNombre());
        existente.setPrecioVenta(producto.getPrecioVenta());
        existente.setPrecioCosto(producto.getPrecioCosto());
        existente.setStock(producto.getStock());

        return productoRepository.save(existente);
    }

    @Override
    public void eliminarProducto(Long id) {
        Producto producto = obtenerPorId(id);
        producto.setActivo(false); // eliminación lógica
        productoRepository.save(producto);
    }
}
