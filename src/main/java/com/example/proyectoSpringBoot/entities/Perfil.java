package com.example.proyectoSpringBoot.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.sql.Date;

@Data
@Entity
@Table(name = "perfiles")
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private long telefono;
    private Date fechaNacimiento; //No sé si ponerlo como string

    //! Relación 1:1 con Usuario
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", unique = true, nullable = false)
    private Usuario usuario;
}
