package com.gestionforraje.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.dto.ChangePasswordForm;
import com.gestionforraje.web.entity.Recorrida;
import com.gestionforraje.web.entity.Usuario;
import com.gestionforraje.web.repository.PotreroRepository;
import com.gestionforraje.web.repository.RecorridaRepository;
import com.gestionforraje.web.service.PotreroService;
import com.gestionforraje.web.service.RecorridaService;



@Controller
public class RecorridaController {
	
	@Autowired
	RecorridaRepository recorridaRepository;
	
	@Autowired
	PotreroRepository potreroRepository;
	
	@Autowired
	RecorridaService recorridaService;
	
	@Autowired
	PotreroService potreroService;
	
	
	@GetMapping("/recorridaForm")
	public String recorridaForm(Model model) {
		model.addAttribute("recorridaForm", new Recorrida());
		model.addAttribute("potreros", potreroRepository.findAll());
		model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
		model.addAttribute("listTab","active");
		return "recorrida-form/recorrida-view";
	}

	@PostMapping("/recorridaForm")
	public String createRecorrida(@Valid @ModelAttribute("recorridaForm")Recorrida recorrida, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("recorridaForm", recorrida);
			model.addAttribute("formTab","active");
		}else {
			try {
				recorridaService.createRecorrida(recorrida);
				model.addAttribute("recorridasForm", new Recorrida());
				model.addAttribute("listTab","active");
			
			} catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
				model.addAttribute("recorridaForm", recorrida);
				model.addAttribute("formTab","active");
				model.addAttribute("potreros", potreroRepository.findAll());
				model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
			
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("recorridaForm", recorrida);
				model.addAttribute("formTab","active");
				model.addAttribute("potreros", potreroRepository.findAll());
				model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
			}
			
		}
		
		model.addAttribute("potreros", potreroRepository.findAll());
		model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
		return "recorrida-form/recorrida-view";
	}

	@GetMapping("/editRecorrida/{id}")
	public String getEditRecorridaForm(Model model, @PathVariable(name="id")Long id)throws Exception{
		Recorrida recorridaToEdit = recorridaService.getRecorridaById(id);
		
		model.addAttribute("recorridaForm", recorridaToEdit);
		model.addAttribute("potreros", potreroRepository.findAll());
		model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
		model.addAttribute("formTab","active");
		model.addAttribute("editMode","true");
		return "recorrida-form/recorrida-view";
	}
	
	@PostMapping("/editRecorrida")
	public String postEditRecorridaForm(@Valid @ModelAttribute("recorridaForm")Recorrida recorrida, BindingResult result, ModelMap model) {
		if(result.hasErrors()) {
			model.addAttribute("recorridaForm", recorrida);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");
			
		}else {
			try {
				recorridaService.updateRecorrida(recorrida);
				model.addAttribute("recorridaForm", new Recorrida());
				model.addAttribute("listTab","active");
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("recorridaForm", recorrida);
				model.addAttribute("formTab","active");
				model.addAttribute("potreros", potreroRepository.findAll());
				model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
				model.addAttribute("editMode","true");
				
			}
		}
		
		model.addAttribute("potreros", potreroRepository.findAll());
		model.addAttribute("recorridaList", recorridaService.getAllRecorridas());
		return "recorrida-form/recorrida-view";
	}
	
	@GetMapping("/recorridaForm/cancel")
	public String cancelEditUser(ModelMap model) {
		return "redirect:/recorridaForm";
	}

}
