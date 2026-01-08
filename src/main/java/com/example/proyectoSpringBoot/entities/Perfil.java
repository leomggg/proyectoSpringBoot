package com.example.proyectoSpringBoot.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String direccion;
    private long telefono;
    private Date fechaNacimiento; //No sé si ponerlo como string

    public Perfil() {}

    public Perfil(String direccion, long telefono, Date fechaNacimiento) {
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }

    public Long getId() {return id;}
    public String getDireccion() {return direccion;}
    public Long getTelefono() {return telefono;}
    public Date getFechaNacimiento() {return fechaNacimiento;}

    public void setId(Long id) {this.id = id;}
    public void setDireccion(String direccion) {this.direccion = direccion;}
    public void setTelefono(long telefono) {this.telefono = telefono;}
    public void setFechaNacimiento(Date fechaNacimiento) {this.fechaNacimiento = fechaNacimiento;}
}
