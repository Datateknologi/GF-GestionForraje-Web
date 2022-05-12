package com.gestionforraje.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
	
	@PostMapping("/userForm")
	public String createUser(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
		}else {
			try {
				usuarioService.createUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("perfiles", perfilRepository.findAll());
				model.addAttribute("userList", usuarioService.getAllUsers());
			
			}
		}
		
		model.addAttribute("perfiles", perfilRepository.findAll());
		model.addAttribute("userList", usuarioService.getAllUsers());
		return "user-form/user-view";
	}
}
