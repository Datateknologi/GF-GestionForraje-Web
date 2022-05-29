package com.gestionforraje.web.controllers;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.service.UsuarioService;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioControllerRest {
	
	UsuarioService usuarioService;
	
	
	public UsuarioControllerRest(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}
	
	
	@GetMapping
	public ResponseEntity<Iterable<Usuario>> getAllUsuarios(){
		Iterable<Usuario> usuarios = usuarioService.getAllUsers();
		return new ResponseEntity<>(usuarios, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable Long id) throws Exception{
		return new ResponseEntity<>(usuarioService.getUserById(id), HttpStatus.OK);
	}
	
	public ResponseEntity<Usuario> saveUsuario(@RequestBody Usuario usuario) throws Exception{
		Usuario usr = usuarioService.createUser(usuario);
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.add("usuario", "/api/usuario/" + usr.getId().toString());
		return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.CREATED);
	}

}
