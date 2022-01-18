package com.example.prueba.servicio.repo;
import java.util.List;

import com.example.prueba.controlador.peticion.CambiarEstado;
import com.example.prueba.controlador.peticion.SalvarSolicitud;
import com.example.prueba.controlador.respuesta.SolicitudUsuario;
import com.example.prueba.modelo.Solicitud;

public interface ISolicitudServi {
    Solicitud salvar(Solicitud solicitud);
    SalvarSolicitud salvarSolicitud(SalvarSolicitud solicitud);
    CambiarEstado cambioEstado(CambiarEstado estado, Solicitud solicitud);
    Solicitud obtenerPorId(int id);
    List<Solicitud> listar();
    List<SolicitudUsuario> listaCompleta();
    List<SolicitudUsuario> listaCompletaEnviada();
    void eliminarPorId(int id);
    void eliminarTodas();
}
