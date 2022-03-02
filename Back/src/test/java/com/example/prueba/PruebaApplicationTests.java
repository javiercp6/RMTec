package com.example.prueba;

import com.example.prueba.controlador.UsuarioControl;
import com.example.prueba.modelo.Usuario;
import com.example.prueba.modelo.Usuario.Rol;
import com.example.prueba.repositorio.IUsuarioRepo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class PruebaApplicationTests {
	@Autowired
	private PasswordEncoder encoder;
	@Autowired
	private IUsuarioRepo repo;
	@Autowired
	private UsuarioControl control;

	@Test
	void contextLoads() {
		Usuario us = new Usuario();
		us.setNombre("Super");
		us.setUsername("admin");
		us.setPassword(encoder.encode("123"));
		us.setRol(Rol.Administrador);
		us.setRolSecundario(null);
		Usuario res = repo.save(us);
		assert(res.getUsername().equals(us.getUsername()));
		
	}

}
