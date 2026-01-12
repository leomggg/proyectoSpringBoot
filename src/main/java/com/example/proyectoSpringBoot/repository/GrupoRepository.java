package com.example.proyectoSpringBoot.repository;

import com.example.proyectoSpringBoot.entities.Perfil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GrupoRepository extends JpaRepository<Perfil, Long> {

    List<Perfil> findByTelefono(Long telefono);

    //Cambiar todo a grupo
}