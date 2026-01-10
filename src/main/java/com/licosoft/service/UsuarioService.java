package com.licosoft.service;

import com.licosoft.entity.Usuario;

public interface UsuarioService {

    Usuario registrarUsuario(Usuario usuario);

    Usuario login(String usuario, String password);
}
