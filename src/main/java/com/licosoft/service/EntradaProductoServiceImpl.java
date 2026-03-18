package com.licosoft.service;

import com.licosoft.entity.EntradaProducto;
import com.licosoft.entity.Producto;
import com.licosoft.repository.EntradaProductoRepository;
import com.licosoft.repository.ProductoRepository;
import org.springframework.stereotype.Service;

@Service
public class EntradaProductoServiceImpl implements EntradaProductoService {

    private final EntradaProductoRepository entradaRepo;
    private final ProductoRepository productoRepo;

    public EntradaProductoServiceImpl(
            EntradaProductoRepository entradaRepo,
            ProductoRepository productoRepo) {

        this.entradaRepo = entradaRepo;
        this.productoRepo = productoRepo;
    }

    @Override
    public EntradaProducto registrarEntrada(EntradaProducto entrada) {

        Producto producto =
                productoRepo.findById(
                        entrada.getProducto().getId()
                ).orElseThrow();

        // aumentar stock
        producto.setStock(
                producto.getStock() + entrada.getCantidad()
        );

        productoRepo.save(producto);

        return entradaRepo.save(entrada);
    }
}