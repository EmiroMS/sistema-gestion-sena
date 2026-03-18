package com.licosoft.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.licosoft.entity.Usuario;
import com.licosoft.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        usuario.setActivo(true);
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario login(String usuario, String password) {

        Usuario user = usuarioRepository.findByUsuarioAndActivoTrue(usuario)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Contraseña incorrecta");
        }

        return user;
    }

    // LISTAR USUARIOS
    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // ELIMINAR USUARIO (DESACTIVAR)
    @Override
    public void eliminarUsuario(Long id) {

        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        usuarioRepository.deleteById(id);
    }
}