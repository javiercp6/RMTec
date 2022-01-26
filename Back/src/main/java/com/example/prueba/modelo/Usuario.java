package com.example.prueba.modelo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Usuario extends Entidad {

    public enum Rol {
        Administrador, Solisitante, Custodio
    }

    @Column
    private String nombre;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    @Enumerated(EnumType.STRING)
    private Rol rol;    
    @Column
    @Enumerated(EnumType.STRING)
    private Rol rolSecundario;    
    @OneToMany(cascade = CascadeType.REMOVE)
    private List<Solicitud> solicitudes;

    public Usuario() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Rol getRolSecundario() {
        return rolSecundario;
    }

    public void setRolSecundario(Rol rolSecundario) {
        this.rolSecundario = rolSecundario;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }
}
