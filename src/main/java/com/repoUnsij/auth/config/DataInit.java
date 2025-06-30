package com.repoUnsij.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repoUnsij.auth.entites.Carreras;
import com.repoUnsij.auth.entites.Roles;
import com.repoUnsij.auth.entites.Usuarios;
import com.repoUnsij.auth.repository.CarreasRepository;
import com.repoUnsij.auth.repository.RolRepository;
import com.repoUnsij.auth.repository.UsuariosRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInit {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CarreasRepository carreasRepository;

    @Autowired
    private UsuariosRepository usuariosRepository;

    @PostConstruct
    public void init() {
        if (rolRepository.count() == 0) {
            rolRepository.saveAll(List.of(
                new Roles(null, "ADMINISTRADOR"),
                new Roles(null, "PROFESOR"),
                new Roles(null, "ALUMNO")
            ));
            System.out.println("Datos iniciales insertados en la tabla 'rol'.");
        }

        if (carreasRepository.count() == 0) {
            carreasRepository.saveAll(List.of(
                new Carreras(null, "Ingeniería en Desarrollo de Software y Sistemas Inteligentes"),
                new Carreras(null, "Ingeniería Forestal"),
                new Carreras(null, "Licenciatura en Administración Turística"),
                new Carreras(null, "Licenciatura en Biología"),
                new Carreras(null, "Licenciatura en Ciencias Ambientales")
            ));
            System.out.println("Datos iniciales insertados en la tabla 'carreras'.");
        }

        if (usuariosRepository.count() == 0) {
            usuariosRepository.saveAll(List.of(
                new Usuarios(null, "Administrador App", "admin@gmail.com", "12345", true, new Roles(1L, null)),
                new Usuarios(null, "Ruben Garcia Hernández", "ruben@gmail.com", "12345", true, new Roles(2L, null)),
                new Usuarios(null, "Adair Martínez Juárez", "adair@gmail.com", "12345", true, new Roles(3L, null)),
                new Usuarios(null, "Alba Alcantara Juárez", "alba@gmail.com", "12345", true, new Roles(3L, null))
            ));
            System.out.println("Datos iniciales insertados en la tabla 'alumnos'.");
        }
    }
}
