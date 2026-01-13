package com.example.proyectoSpringBoot.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@Table(name = "usuarios")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String contrasena;

    //! Relación 1:1 con Perfil
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Perfil perfil;

    //! Relacion 1:N con Publicación
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Publicacion> publicaciones = new ArrayList<>();

    //! Relación N:M con Grupo
    //? Tabla intermedia
    @ToString.Exclude
    @ManyToMany
    @EqualsAndHashCode.Exclude
    @JoinTable(name = "usuarios_roles",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name  = "rol_id"))
    private Set<Grupo> grupos = new HashSet<>(); //* Set porque es mejor para la gestión de la BBDD

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
    }
}
