package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Venta;

public interface VentaRepository extends JpaRepository<Venta, Long> {
}
