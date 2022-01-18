package com.example.prueba.modelo;


import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Solicitud extends Entidad{
    private String marca;
    private String modelo;
    private String noserie;
    private String macwifi;
    private String maccable;
    private String tipo;
    private String estado;
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
