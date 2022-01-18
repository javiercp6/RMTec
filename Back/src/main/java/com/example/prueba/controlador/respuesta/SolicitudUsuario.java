package com.example.prueba.controlador.respuesta;

import com.example.prueba.modelo.Solicitud;
import com.example.prueba.modelo.Usuario;

import java.io.Serializable;

public class SolicitudUsuario implements Serializable {
    private Solicitud solicitud;
    private int idUsuario;
    private String nombreUsuario;

    public SolicitudUsuario() {
    }

    public SolicitudUsuario(Solicitud solicitud, int idUsuario, String nombreUsuario) {
        this.solicitud = solicitud;
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
