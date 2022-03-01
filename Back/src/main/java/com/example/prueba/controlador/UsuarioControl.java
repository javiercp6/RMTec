package com.example.prueba.controlador;

import com.example.prueba.modelo.Solicitud;
import com.example.prueba.modelo.Usuario;
import com.example.prueba.servicio.repo.IUsuarioServi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/usuario")
public class UsuarioControl {
    @Autowired
    private IUsuarioServi servi;
    @Autowired
    private PasswordEncoder encoder;

    @GetMapping(value = "/listar")
    public List<Usuario> listar(){
        return servi.listar();
    }
    

     @GetMapping(value = "/listarporsolicitud")
    public List<Usuario> listarPorSol(){
        return servi.listarPorSolicitud();
    }

    @PostMapping(value = "/obtenerporusername/{username}")
    public List<Solicitud> obtenerPoruser(@PathVariable String username){
        return servi.obtenerPorUserName(username);
    }

    @PostMapping(value = "/salvar")
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuario.setPassword(encoder.encode(usuario.getPassword()));
        return ResponseEntity.ok(servi.salvar(usuario));
    }

    @PutMapping(value = "/modificar")
    public ResponseEntity<Usuario> modificar(@RequestBody Usuario usuario){
        Usuario u = servi.obtenerPorId(usuario.getId());
        if(u != null)
            servi.salvar(usuario);
        else
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        return ResponseEntity.ok(usuario);
    }

    @DeleteMapping(value = "/eliminar/{id}")
    public void eliminar(@PathVariable int id){
        servi.eliminarPorId(id);
    }
}
