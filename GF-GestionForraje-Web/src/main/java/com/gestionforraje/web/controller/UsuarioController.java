package com.gestionforraje.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.repository.PerfilRepository;
import com.gestionforraje.web.repository.UsuarioRepository;
import com.gestionforraje.web.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/userForm")
	public String userForm(Model model) {
		model.addAttribute("userForm", new Usuario());
		model.addAttribute("perfiles", perfilRepository.findAll());
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("listTab","active");
		return "user-form/user-view";
	}
}
