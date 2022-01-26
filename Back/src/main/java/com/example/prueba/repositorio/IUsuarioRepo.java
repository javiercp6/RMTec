package com.example.prueba.repositorio;

import com.example.prueba.modelo.Solicitud;
import com.example.prueba.modelo.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer> {
    Usuario findById(int id);
    Usuario findBySolicitudes(Solicitud solicitud);
    Usuario findByUsername(String username);
}
