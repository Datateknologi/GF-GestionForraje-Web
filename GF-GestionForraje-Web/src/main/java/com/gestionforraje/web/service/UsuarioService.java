package com.gestionforraje.web.service;

import javax.validation.Valid;

import com.gestionforraje.web.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsers();

	public Usuario createUser(Usuario user) throws Exception;

}
