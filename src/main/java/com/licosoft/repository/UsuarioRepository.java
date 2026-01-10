package com.licosoft.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.licosoft.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsuarioAndActivoTrue(String usuario);
}
