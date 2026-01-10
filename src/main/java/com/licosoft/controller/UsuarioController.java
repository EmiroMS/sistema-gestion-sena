package com.licosoft.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.licosoft.entity.Usuario;
import com.licosoft.entity.dto.ApiResponse;
import com.licosoft.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // REGISTRO
    @PostMapping("/registro")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario) {
        return ResponseEntity.ok(usuarioService.registrarUsuario(usuario));
    }

    // LOGIN
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<Usuario>> login(@RequestBody Usuario usuario) {

        Usuario user = usuarioService.login(
                usuario.getUsuario(),
                usuario.getPassword()
        );

        return ResponseEntity.ok(
                new ApiResponse<>(
                        true,
                        "Usuario autenticado correctamente",
                        null
                )
        );
    }
}