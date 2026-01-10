package com.licosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
