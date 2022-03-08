package com.example.prueba.modelo;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Solicitud extends Entidad{
    @Column(nullable = false)
    private String marca;
    @Column(nullable = false)
    private String modelo;
    @Column(unique = true, nullable = false)
    private String noserie;
    @Column(nullable = false)
    private String macwifi;
    @Column(nullable = false)
    private String maccable;
    @Column(nullable = false)
    private String tipo;
    @Column(nullable = false)
    private String estado;
    @Column(nullable = false)
    private Date fecha;
    
    public Solicitud() {    }

    public Solicitud(String marca, String modelo, String noserie, String macwifi, String maccable, String tipo, String estado, Date fecha) {
        this.marca = marca;
        this.modelo = modelo;
        this.noserie = noserie;
        this.macwifi = macwifi;
        this.maccable = maccable;
        this.tipo = tipo;
        this.estado = estado;
        this.fecha = fecha;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getNoserie() {
        return noserie;
    }

    public void setNoserie(String noserie) {
        this.noserie = noserie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMacwifi() {
        return macwifi;
    }

    public void setMacwifi(String macwifi) {
        this.macwifi = macwifi;
    }

    public String getMaccable() {
        return maccable;
    }

    public void setMaccable(String maccable) {
        this.maccable = maccable;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    



    
    

}
