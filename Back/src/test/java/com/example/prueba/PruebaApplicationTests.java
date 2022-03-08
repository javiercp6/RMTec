package com.example.prueba;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;
import java.util.List;

import com.example.prueba.controlador.SolicitudControl;
import com.example.prueba.controlador.UsuarioControl;
import com.example.prueba.controlador.peticion.SalvarSolicitud;
import com.example.prueba.controlador.peticion.CambiarEstado;
import com.example.prueba.seguridad.LoginC;
import com.example.prueba.seguridad.LoginSo;
import com.example.prueba.modelo.Solicitud;
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
	private UsuarioControl controlUsuario;
	@Autowired
	private SolicitudControl controlsolicitud;
	@Autowired
	private LoginC controlLogin;

	
	@Test
	 void contextLoads() {
		Usuario us = new Usuario();
		us.setNombre("Super");
		us.setUsername("admin");
		us.setPassword(encoder.encode("123"));
		us.setRol(Rol.Administrador);
		us.setRolSecundario(null);
		Usuario res = repo.save(us);
		controlUsuario.salvar(us).getBody();
		assert(res.getUsername().equals(us.getUsername()));
		
	}
    /* Usuario u = new Usuario();
    u.setNombre("Javier");
    u.setPassword("javiercp");
    u.setUsername("javiercp");
    Usuario salvaUsuario = controlUsuario.salvar(u).getBody();
    assertNotNull(salvaUsuario);
    
    Usuario modificarUsuario = controlUsuario.modificar(u).getBody();
    assertNotNull(modificarUsuario); */



	@Test
	void testusuario(){
		int l = controlUsuario.listar().size();
        assertTrue(l >= 0);

		int f = controlUsuario.obtenerPoruser("admin").size();
		assertTrue(f >= 0);

		LoginSo o = new LoginSo();
		o.setUsuario("admin");
		o.setContrasenna("123");

		try{
			String token = controlLogin.createAuthenticationToken(o).getBody().toString();
			assertNotNull(token);
		} catch(Exception e){

		}



      
	};

	



	@Test
	void testsolicitud(){
		
		
		//Salvar Solicitud
        Date fecha = new Date();
		Solicitud s = new Solicitud("Hp", "Pavilion g6", "123", "abc", "abc", "laptop", "Enviada", fecha);
		SalvarSolicitud ss = new SalvarSolicitud("admin", s);
		//assertTrue(ss.getNombreUsuario().equals(salvarsol.getNombreUsuario()));
		assertNotNull(controlsolicitud.salvarsolicitud(ss).getBody());
		
        //Salvar la mismoa
        Date fecha2 = new Date();
		Solicitud s2 = new Solicitud("Hp", "Pavilion g6", "123", "abc", "abc", "laptop", "Enviada", fecha2);
		SalvarSolicitud ss2 = new SalvarSolicitud("admin", s2);
		//assertTrue(ss.getNombreUsuario().equals(salvarsol.getNombreUsuario()));
        assertThrows(Exception.class, ()->{controlsolicitud.salvarsolicitud(ss2);});
		
        //Salvar solicitud con vampos nulos
		Solicitud s3 = new Solicitud();
		SalvarSolicitud ss3 = new SalvarSolicitud("admin", s3);
		//SalvarSolicitud salvarsol3 = controlsolicitud.salvarsolicitud(ss3).getBody();
		//assertTrue(ss.getNombreUsuario().equals(salvarsol.getNombreUsuario()));
		assertThrows(Exception.class, ()->{controlsolicitud.salvarsolicitud(ss3);});
		
        //Modificar Solicitud
		Solicitud modificar = controlsolicitud.modificar(s).getBody();
		assertNotNull(modificar);
		
        //Modificar con campos nulos
		assertThrows(Exception.class, ()->{controlsolicitud.modificar(s3);});
		
        //Aceptar Solicitud
        CambiarEstado estadoA = new CambiarEstado(s.getId() , "Aceptada");
        CambiarEstado estadoB = new CambiarEstado(s.getId() , "Denegada");
		
		CambiarEstado aceptar = controlsolicitud.cabiarestado(estadoA).getBody();
		CambiarEstado denegar = controlsolicitud.cabiarestado(estadoB).getBody();
		assertTrue(aceptar.getEstado().equals("Aceptada"));
		assertTrue(denegar.getEstado().equals("Denegada"));
		
		controlsolicitud.listac();
		int listac = controlsolicitud.listac().size();
		assertTrue(listac >= 0);

		/* Solicitud eliminar = controlsolicitud.eliminarPorId(1).getBody();
		assertNotNull(eliminar);
		 */
		/* UsuarioSolicitud eliminarTodas = controlsolicitud.eliminar().getBody();
		assertNotNull(eliminarTodas);*/
		

	}


}
