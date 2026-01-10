package com.licosoft.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.DetalleCompra;

public interface DetalleCompraRepository extends JpaRepository<DetalleCompra, Long> {
}