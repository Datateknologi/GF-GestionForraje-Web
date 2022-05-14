package com.gestionforraje.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.dto.ChangePasswordForm;
import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Iterable<Usuario> getAllUsers() {
		return repository.findAll();
	}

	private boolean checkUsernameAvailable(Usuario user) throws Exception {
		Optional<Usuario> userFound = repository.findByUsuario(user.getUsuario());
		if(userFound.isPresent()) {
			throw new Exception("Usuario no diponible");
		}
		return true;
	}
	
	private boolean checkPasswordValid(Usuario user) throws Exception {
		
		if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new Exception("Confirm Password es obligatorio");
		}
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y Confirm Password no son iguales");
		}
		return true;
	}

	@Override
	public Usuario createUser(Usuario user) throws Exception {
		if(checkUsernameAvailable(user)&& checkPasswordValid(user)) {
			
			String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodePassword);
			
			user = repository.save(user);
		}
		return user;
	}

	@Override
	public Usuario getUserById(Long id) throws Exception {
		
		return repository.findById(id).orElseThrow(()-> new Exception("El Usuario no existe"));
	}

	@Override
	public Usuario updateUser(Usuario fromUser) throws Exception {
		Usuario toUser = getUserById(fromUser.getId());
		mapUser(fromUser, toUser);
		return repository.save(toUser);

		}

	protected void mapUser(Usuario from,Usuario to) {
		to.setUsuario(from.getUsuario());
		to.setNombre(from.getNombre());
		to.setApellido(from.getApellido());
		to.setEmail(from.getEmail());
		to.setPerfiles(from.getPerfiles());
	
	}

	@Override
	public void deleteUser(Long id) throws Exception {
		Usuario user = getUserById(id);
		repository.delete(user);
		
	}

	@Override
	public Usuario changePassword(ChangePasswordForm form) throws Exception {
		Usuario user = getUserById(form.getId());
		
		
		if( !isLoggedUserADMIN() && !user.getPassword().equals(form.getCurrentPassword())) {
			throw new Exception("Password Actual Incorrecto.");
		
		}
		if(user.getPassword().equals(form.getNewPassword())) {
			throw new Exception ("Nuevo Password debe ser diferente al Password actual.");
		}
		if(!form.getNewPassword().equals(form.getConfirmPassword())) {
			throw new Exception ("Nuevo Password y Current Password no coinciden.");
		}
		
		String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
		user.setPassword(encodePassword);
		return repository.save(user);
	}
	
	public boolean isLoggedUserADMIN(){
		 return loggedUserHasRole("ROLE_ADMIN");
		}

		public boolean loggedUserHasRole(String role) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			UserDetails loggedUser = null;
			Object roles = null; 
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			
				roles = loggedUser.getAuthorities().stream()
						.filter(x -> role.equals(x.getAuthority() ))      
						.findFirst().orElse(null); //loggedUser = null;
			}
			return roles != null ?true :false;
		}
		
		public Usuario getLoggedUser() throws Exception {
			//Obtener el usuario logeado
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			UserDetails loggedUser = null;

			//Verificar que ese objeto traido de sesion es el usuario
			if (principal instanceof UserDetails) {
				loggedUser = (UserDetails) principal;
			}
			
			Usuario myUser = repository
					.findByUsuario(loggedUser.getUsername()).orElseThrow(() -> new Exception("Problemas obteniendo usuario de sesion."));
			
			return myUser;
		}


}
