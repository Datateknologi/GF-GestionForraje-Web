package com.gestionforraje.web.controller;

import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.Exeption.UsernameOrIdNotFound;
import com.gestionforraje.web.dto.ChangePasswordForm;
import com.gestionforraje.web.entity.Predio;
import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.repository.PerfilRepository;
import com.gestionforraje.web.repository.UsuarioRepository;
import com.gestionforraje.web.service.PredioService;
import com.gestionforraje.web.service.UsuarioService;

@Controller
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	PerfilRepository perfilRepository;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	PredioService predioService;
	
	@GetMapping({"/","/login"})
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
			
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("perfiles", perfilRepository.findAll());
				model.addAttribute("userList", usuarioService.getAllUsers());
			
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
	
	@GetMapping("/editUser/{id}")
	public String getEditUserForm(Model model, @PathVariable(name="id")Long id)throws Exception{
		Usuario userToEdit = usuarioService.getUserById(id);
		
		model.addAttribute("userForm", userToEdit);
		model.addAttribute("perfiles", perfilRepository.findAll());
		model.addAttribute("userList", usuarioService.getAllUsers());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		model.addAttribute("passwordForm",new ChangePasswordForm(id));
	
	    return "user-form/user-view";
	}
	
	@PostMapping("/editUser")
	public String postEditUserForm(@Valid @ModelAttribute("userForm")Usuario user, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("userForm", user);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
		}else {
			try {
				usuarioService.updateUser(user);
				model.addAttribute("userForm", new Usuario());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("userForm", user);
				model.addAttribute("formTab","active");
				model.addAttribute("perfiles", perfilRepository.findAll());
				model.addAttribute("userList", usuarioService.getAllUsers());
				model.addAttribute("editMode","true");
				model.addAttribute("passwordForm",new ChangePasswordForm(user.getId()));
			}
		}
		
		model.addAttribute("perfiles", perfilRepository.findAll());
		model.addAttribute("userList", usuarioService.getAllUsers());
		return "user-form/user-view";
	}
	
	@GetMapping("/userForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/userForm";
	}

	@GetMapping("/deleteUser/{id}")
	public String deleteUser(Model model, @PathVariable(name="id")Long id){
		try {
			usuarioService.deleteUser(id);
		} catch (UsernameOrIdNotFound uoin) {
			model.addAttribute("listErrorMessage",uoin.getMessage());
		}
		return userForm(model);
	}

	@PostMapping("/editUser/changePassword")
 	public ResponseEntity postEditUseChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors) {
 		try {
			if(errors.hasErrors()) {
				String result = errors.getAllErrors()
                        .stream().map(x -> x.getDefaultMessage())
                        .collect(Collectors.joining(""));

            throw new Exception(result);
			}
			usuarioService.changePassword(form);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
 		return ResponseEntity.ok("Success");
 	}

	@GetMapping("/predioForm")
	 public String getPredioForm(Model model){
		 model.addAttribute("predioForm", new Predio());
		 model.addAttribute("predioList", predioService.getAllPredios());
		 model.addAttribute("listTab","active");
		 return "predio-form/predio-view";
	 }
}
