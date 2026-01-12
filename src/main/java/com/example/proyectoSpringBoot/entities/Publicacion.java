package com.example.proyectoSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import java.sql.Date;

@Data
@Entity
public class Publicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String titulo;
    private String contenido;
    private Date fechaCreacion;

    //@onetomuchos 1:N to Usuario

    public Publicacion(long id, String titulo, String contenido, Date fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.fechaCreacion = fechaCreacion;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}
    public String getTitulo() {return titulo;}
    public void setTitulo(String titulo) {this.titulo = titulo;}
    public String getContenido() {return contenido;}
    public void setContenido(String contenido) {this.contenido = contenido;}
    public Date getFechaCreacion() {return fechaCreacion;}
    public void setFechaCreacion(Date fechaCreacion) {this.fechaCreacion = fechaCreacion;}
}

