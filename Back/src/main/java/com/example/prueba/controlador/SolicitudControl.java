package com.example.prueba.controlador;

import java.util.Date;
import java.util.List;

import com.example.prueba.controlador.peticion.CambiarEstado;
import com.example.prueba.controlador.peticion.SalvarSolicitud;
import com.example.prueba.controlador.respuesta.SolicitudUsuario;
import com.example.prueba.modelo.Solicitud;
import com.example.prueba.servicio.repo.ISolicitudServi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitud")
@CrossOrigin
public class SolicitudControl {
    
    @Autowired
    private ISolicitudServi servicio;

    @GetMapping(value = "/listar")
    public List<Solicitud> listar() {
        return servicio.listar();
    }

    @GetMapping(value = "/listacompleta")
    public List<SolicitudUsuario> listac(){
        List<SolicitudUsuario> l = servicio.listaCompleta();
        return servicio.listaCompleta();
    }

    @GetMapping(value = "/listacompletaenviada")
    public List<SolicitudUsuario> listace(){
        List<SolicitudUsuario> l = servicio.listaCompletaEnviada();
        return servicio.listaCompletaEnviada();
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Solicitud> salvar(@RequestBody Solicitud solicitud) {
        Solicitud s = servicio.salvar(solicitud);
        return new ResponseEntity<>(s, HttpStatus.OK);
    }

    @PostMapping(value = "/salvarsolicitud")
    public ResponseEntity<SalvarSolicitud> salvarsolicitud(@RequestBody SalvarSolicitud solicitud) {
        solicitud.getSolicitud().setFecha(new Date());
        return ResponseEntity.ok(servicio.salvarSolicitud(solicitud));
    }

    @PutMapping(value = "/cabiarestado")
    public ResponseEntity<CambiarEstado> cabiarestado(@RequestBody CambiarEstado estado){
        Solicitud solicitud = servicio.obtenerPorId(estado.getIdSolicitud());
        if(solicitud == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(servicio.cambioEstado(estado, solicitud));
    }

    @PutMapping(value = "/modificar")
    public ResponseEntity<Solicitud> modificar(@RequestBody Solicitud solicitud) {
        Solicitud sol = servicio.obtenerPorId(solicitud.getId());
        if (sol != null) {
            servicio.salvar(solicitud);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(solicitud, HttpStatus.OK);

    }

    @DeleteMapping(value = "/eliminar/{id}")
    public ResponseEntity<Solicitud> eliminarPorId(@PathVariable int id){
        Solicitud sol = servicio.obtenerPorId(id);
        if(sol != null){
            servicio.eliminarPorId(id);
        }else{
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(sol, HttpStatus.OK);
    }

    @DeleteMapping(value = "/eliminar")
    public ResponseEntity<Solicitud> eliminar(){
        servicio.eliminarTodas();
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}
