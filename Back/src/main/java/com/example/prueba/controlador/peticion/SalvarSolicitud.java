package com.example.prueba.controlador.peticion;

import com.example.prueba.modelo.Solicitud;

public class SalvarSolicitud {
    int idUsuario;
    Solicitud solicitud;
    public SalvarSolicitud(int idUsuario, Solicitud solicitud) {
        this.idUsuario = idUsuario;
        this.solicitud = solicitud;
    }
    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }
    public Solicitud getSolicitud() {
        return solicitud;
    }
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
}
