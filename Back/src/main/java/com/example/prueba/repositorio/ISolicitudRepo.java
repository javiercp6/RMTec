package com.example.prueba.repositorio;

import com.example.prueba.modelo.Solicitud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ISolicitudRepo extends JpaRepository<Solicitud, Integer>{
    Solicitud findByEstado(String estado);

}
