package com.example.prueba.controlador.peticion;

import com.example.prueba.modelo.Solicitud;

public class SalvarSolicitud {
    String nombreUsuario;
    Solicitud solicitud;
    public SalvarSolicitud(String nombreUsuario, Solicitud solicitud) {
        this.nombreUsuario = nombreUsuario;
        this.solicitud = solicitud;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
}
