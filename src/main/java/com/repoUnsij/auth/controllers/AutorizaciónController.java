package com.repoUnsij.auth.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repoUnsij.auth.entites.Usuarios;
import com.repoUnsij.auth.response.ErrorResponse;
import com.repoUnsij.auth.services.UsuariosService;

//@CrossOrigin(origins = "http://localhost:4200/")
@RestController
@RequestMapping("/api/autorizacion")
public class AutorizaciónController {

    @Autowired
	private UsuariosService usuariosService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuarios usuario) {
        Optional<Usuarios> usuarioOptional = usuariosService.getUsuarioByEmail(usuario.getCorreo());

        if (usuarioOptional.isPresent()) {
            Usuarios encontrado = usuarioOptional.get();

            if (encontrado.getContraseña().equals(usuario.getContraseña())) {
                return ResponseEntity.ok(encontrado);
            } else {
                return ResponseEntity
                        .status(HttpStatus.UNAUTHORIZED)
                        .body(new ErrorResponse(401, "Contraseña incorrecta"));
            }

        } else {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(new ErrorResponse(404, "Usuario no encontrado"));
        }
    }
}
