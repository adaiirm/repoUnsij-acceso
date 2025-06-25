package com.repoUnsij.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repoUnsij.auth.entites.Usuarios;
import com.repoUnsij.auth.repository.UsuariosRepository;

@Service
public class UsuariosService {

    @Autowired
    private UsuariosRepository usuariosRepository;

    // Obtener un usuario por id
    public Optional<Usuarios> getUsuarioById(Long id) {
        return usuariosRepository.findById(id);
    }

    public Optional<Usuarios> getUsuarioByEmail(String email) {
    return usuariosRepository.findByEmail(email);
}
}
