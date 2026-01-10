package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Proveedor;

public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
