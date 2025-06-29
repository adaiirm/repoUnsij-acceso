package com.repoUnsij.auth.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.repoUnsij.auth.entites.Carreras;
import com.repoUnsij.auth.entites.Roles;
import com.repoUnsij.auth.repository.CarreasRepository;
import com.repoUnsij.auth.repository.RolRepository;

import jakarta.annotation.PostConstruct;

@Component
public class DataInit {

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private CarreasRepository carreasRepository;

    @PostConstruct
    public void init() {
        if (rolRepository.count() == 0) {
            rolRepository.saveAll(List.of(
                new Roles(0L, "ADMINISTRADOR"),
                new Roles(0L, "PROFESOR"),
                new Roles(0L, "ALUMNO")
            ));
            System.out.println("Datos iniciales insertados en la tabla 'rol'.");
        }

        if (carreasRepository.count() == 0) {
            carreasRepository.saveAll(List.of(
                new Carreras(0L, "Ingeniería en Desarrollo de Software y Sistemas Inteligentes"),
                new Carreras(0L, "Ingeniería Forestal"),
                new Carreras(0L, "Licenciatura en Administración Turística"),
                new Carreras(0L, "Licenciatura en Biología"),
                new Carreras(0L, "Licenciatura en Ciencias Ambientales")
            ));
            System.out.println("Datos iniciales insertados en la tabla 'rol'.");
        }
    }
}
