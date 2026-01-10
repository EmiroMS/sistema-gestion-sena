package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long> {
}