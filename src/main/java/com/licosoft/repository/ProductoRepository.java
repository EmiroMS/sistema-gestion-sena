package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Producto;

import java.util.List;

public interface ProductoRepository extends JpaRepository<Producto, Long> {

    List<Producto> findByActivoTrue();
}