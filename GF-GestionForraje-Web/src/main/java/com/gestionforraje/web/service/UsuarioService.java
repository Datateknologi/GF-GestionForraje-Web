package com.gestionforraje.web.service;



import com.gestionforraje.web.Exeption.UsernameOrIdNotFound;
import com.gestionforraje.web.dto.ChangePasswordForm;
import com.gestionforraje.web.entity.Usuario;

public interface UsuarioService {
	
	public Iterable<Usuario> getAllUsers();

	public Usuario createUser(Usuario user) throws Exception;
	
	public Usuario getUserById(Long id) throws Exception;
	
	public Usuario updateUser(Usuario user) throws Exception;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;

	public Usuario changePassword(ChangePasswordForm form) throws Exception;

}
