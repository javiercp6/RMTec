package com.example.prueba.servicio;

import com.example.prueba.modelo.Usuario;
import com.example.prueba.repositorio.IUsuarioRepo;
import com.example.prueba.servicio.repo.IUsuarioServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class UsuarioServiImpl implements IUsuarioServi {
    @Autowired
    private IUsuarioRepo repo;

    @Override
    public Usuario salvar(Usuario usuario) {
        return repo.save(usuario);
    }

    @Override
    public Usuario obtenerPorId(int id) {
        return repo.findById(id);
    }

    @Override
    public Usuario obtenerPorUserName(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @Override
    public void eliminarPorId(int id) {
        repo.deleteById(id);
    }
    

    @Override
    public List<Usuario> listarPorSolicitud() {
        List<Usuario> resultado = new LinkedList<>();
        List<Usuario> usuarios = repo.findAll();
        for (Usuario u : usuarios) {
            if (u.getSolicitudes().isEmpty() == false) {
                resultado.add(u);
            }
        }
        return resultado;
    }

    @Override
    public Usuario getByUsername(String arg0) {
        return repo.findByUsername(arg0);
    }
}
