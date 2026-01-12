package com.example.proyectoSpringBoot.services;

import com.example.proyectoSpringBoot.entities.Perfil;
import com.example.proyectoSpringBoot.repository.PerfilRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PerfilService {
    private final PerfilRepository perfilRepository;

    public PerfilService(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    public Perfil guardarPerfil(Perfil perfil) {
        return perfilRepository.save(perfil);
    }

    public List<Perfil> obtenerPerfil() {
        return perfilRepository.findAll();
    }
}
