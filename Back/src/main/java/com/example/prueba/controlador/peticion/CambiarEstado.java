package com.example.prueba.controlador.peticion;

public class CambiarEstado {
    int idSolicitud;
    String estado;
    public CambiarEstado(int idSolicitud, String estado) {
        this.idSolicitud = idSolicitud;
        this.estado = estado;
    }
    public int getIdSolicitud() {
        return idSolicitud;
    }
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    
}
