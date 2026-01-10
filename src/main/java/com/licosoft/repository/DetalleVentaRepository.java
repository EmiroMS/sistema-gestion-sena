package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.DetalleVenta;

public interface DetalleVentaRepository extends JpaRepository<DetalleVenta, Long> {
}
