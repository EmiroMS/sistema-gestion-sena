package com.licosoft.service;

import java.util.List;
import com.licosoft.entity.Usuario;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);

    Usuario login(String usuario, String password);

    List<Usuario> listarUsuarios();

    void eliminarUsuario(Long id);
}