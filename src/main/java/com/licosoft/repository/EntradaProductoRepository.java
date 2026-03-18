package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.licosoft.entity.EntradaProducto;

public interface EntradaProductoRepository extends JpaRepository<EntradaProducto, Long> {
}