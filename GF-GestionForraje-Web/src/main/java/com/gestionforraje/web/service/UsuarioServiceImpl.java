package com.gestionforraje.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	UsuarioRepository repository;

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


}
