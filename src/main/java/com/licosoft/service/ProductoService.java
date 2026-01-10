package com.licosoft.service;


import java.util.List;

import com.licosoft.entity.Producto;

public interface ProductoService {

    Producto crearProducto(Producto producto);

    List<Producto> listarProductos();

    Producto obtenerPorId(Long id);

    Producto actualizarProducto(Long id, Producto producto);

    void eliminarProducto(Long id);
}
