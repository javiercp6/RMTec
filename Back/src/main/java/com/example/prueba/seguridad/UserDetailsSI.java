package com.example.prueba.seguridad;

import java.util.HashSet;
import java.util.Set;

import com.example.prueba.modelo.Usuario;
import com.example.prueba.servicio.repo.IUsuarioServi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSI implements UserDetailsService {

    @Autowired
    private IUsuarioServi usuarioService;

    @Override
    public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {

        Set<GrantedAuthority> authorities = new HashSet<>();

        if(arg0.equals("admin")){
            authorities.add(new GrantedAuthority() {
                @Override
                public String getAuthority() {
                    return "Administrador";
                }
            });
            return new User("admin", "1234", authorities);
        } else{
            Usuario usuario = usuarioService.getByUsername(arg0);
            if(usuario.getRol()!= null){
                authorities.add(new SimpleGrantedAuthority(usuario.getRol().name()));
            }
            if(usuario.getRolSecundario()!= null){
                authorities.add(new SimpleGrantedAuthority(usuario.getRolSecundario().name()));
            }
            return new User(usuario.getUsername(), usuario.getPassword(), authorities);
        }
    }
}
