package com.gestionforraje.web.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gestionforraje.web.entity.Perfil;
import com.gestionforraje.web.repository.UsuarioRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    UsuarioRepository usuarioRepository;
	

	@Override
	public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {
		com.gestionforraje.web.entity.Usuario appUser = usuarioRepository.findByUsuario(usuario).orElseThrow(() -> new UsernameNotFoundException("Login Usuario Invalido."));

        Set<GrantedAuthority> grantList = new HashSet<GrantedAuthority>();
        
        for(Perfil perfil: appUser.getPerfiles()) {
        	GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(perfil.getDescripcion());
	            grantList.add(grantedAuthority);
        }
        UserDetails user = (UserDetails) new User(usuario,appUser.getPassword(),grantList);
        return user;
	}

}
