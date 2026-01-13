package com.example.proyectoSpringBoot.repository;

import com.example.proyectoSpringBoot.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByNombre(String nombre);
}