package com.example.prueba.servicio;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.example.prueba.controlador.peticion.CambiarEstado;
import com.example.prueba.controlador.peticion.SalvarSolicitud;
import com.example.prueba.controlador.respuesta.SolicitudUsuario;
import com.example.prueba.modelo.Solicitud;
import com.example.prueba.modelo.Usuario;
import com.example.prueba.repositorio.ISolicitudRepo;
import com.example.prueba.repositorio.IUsuarioRepo;
import com.example.prueba.servicio.repo.ISolicitudServi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SolicitudServiImple  implements ISolicitudServi{
    
    @Autowired
    private ISolicitudRepo repo;

    @Autowired
    private IUsuarioRepo usuarioRepo;

    @Override
    public Solicitud salvar(Solicitud solicitud) {
        return repo.save(solicitud);
    }

    @Override
    public Solicitud obtenerPorId(int id) {
        return repo.findById(id).get();
    }
    
    @Override
    public List<Solicitud> listar() {
        return repo.findAll();
    }

    @Override
    public List<SolicitudUsuario> listaCompleta() {
        List<SolicitudUsuario> resultado = new LinkedList<>();
        List<Solicitud> solicitudes = repo.findAll();
        for(Solicitud s : solicitudes){
            resultado.add(new SolicitudUsuario(s, usuarioRepo.findBySolicitudes(s).getId(), usuarioRepo.findBySolicitudes(s).getNombre()));
        }
        return resultado;
    }
    
    @Override
    public List<SolicitudUsuario> listaCompletaEnviada() {
        List<SolicitudUsuario> resultado = new LinkedList<>();
        List<Solicitud> solicitudes = repo.findAll();
        /*solicitudes.stream()
                .filter(so -> so.getEstado().equals("Enviada"))
                .forEach(s -> {
                    resultado.add( new SolicitudUsuario(s, usuarioRepo.findBySolicitudes(s).getId(), usuarioRepo.findBySolicitudes(s).getNombre()));
                });*/
        for(Solicitud s : solicitudes){
            if (s.getEstado().equals("Enviada")) {
                resultado.add(new SolicitudUsuario(s, usuarioRepo.findBySolicitudes(s).getId(), usuarioRepo.findBySolicitudes(s).getNombre()));
            }
        }
        return resultado;
    }

    @Override
    public void eliminarPorId(int id) {
        Solicitud s = repo.findById(id).get();
        usuarioRepo.findBySolicitudes(s).getSolicitudes().remove(s);
        repo.deleteById(id);
    }

    @Override
    public void eliminarTodas() {
        List<Solicitud> solicitudes = repo.findAll();
        for(Solicitud s : solicitudes){
            usuarioRepo.findBySolicitudes(s).setSolicitudes(null);
        }
        repo.deleteAll();
        
    }

    @Override
    public void denegar() {
        for (Solicitud s : repo.findAll()){
            if(s.getEstado().equals("Enviada")){
                s.setEstado("Denegada");
                repo.save(s);
            }
        }
    }

    @Override
    public void aceptar() {
        for (Solicitud s : repo.findAll()){
            if(s.getEstado().equals("Enviada")){
                s.setEstado("Aceptada");
                repo.save(s);
            }
        }

    }

    @Override
    public SalvarSolicitud salvarSolicitud(SalvarSolicitud solicitud) {
        repo.save(solicitud.getSolicitud());
        Usuario u = usuarioRepo.findByUsername(solicitud.getNombreUsuario());
        u.getSolicitudes().add(solicitud.getSolicitud());
        usuarioRepo.save(u);
        return solicitud;
    }

    @Override
    public CambiarEstado cambioEstado(CambiarEstado estado, Solicitud solicitud) {
        solicitud.setEstado(estado.getEstado());
        repo.save(solicitud);
        return estado;
    }



}

