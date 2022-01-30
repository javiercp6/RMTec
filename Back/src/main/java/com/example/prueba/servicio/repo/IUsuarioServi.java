package com.example.prueba.servicio.repo;

import com.example.prueba.modelo.Solicitud;
import com.example.prueba.modelo.Usuario;

import java.util.List;

public interface IUsuarioServi {
    Usuario salvar(Usuario usuario);
    Usuario obtenerPorId(int id);
    List<Solicitud> obtenerPorUserName(String username);
    List<Usuario> listar();
    List<Usuario> listarPorSolicitud();
    void eliminarPorId(int id);
    Usuario getByUsername(String arg0);
}
