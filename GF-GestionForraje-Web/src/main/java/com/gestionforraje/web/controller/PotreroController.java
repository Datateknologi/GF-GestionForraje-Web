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

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.repository.EstadoRepository;
import com.gestionforraje.web.repository.PredioRepository;
import com.gestionforraje.web.service.PotreroService;

@Controller
public class PotreroController {
	
	@Autowired
	PotreroService potreroService;
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Autowired
	PredioRepository predioRepository;
	
	
	
	@GetMapping("/potreroForm")
	public String potreroForm(Model model) {
		model.addAttribute("potreroForm", new Potrero());
		model.addAttribute("estados", estadoRepository.findAll());
		model.addAttribute("predios", predioRepository.findAll());
		model.addAttribute("potreroList", potreroService.getAllPotreros());
		model.addAttribute("listTab","active");
		return "potrero-form/potrero-view";
	}

	@PostMapping("/potreroForm")
	public String createPotrero(@Valid @ModelAttribute("potreroForm")Potrero potrero, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("potreroForm", potrero);
			model.addAttribute("formTab","active");
		}else {
			try {
				potreroService.createPotrero(potrero);
				model.addAttribute("potreroForm", new Potrero());
				model.addAttribute("listTab","active");
				
			}catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(),null,cfve.getMessage());
				model.addAttribute("potreroForm", potrero);
				model.addAttribute("formTab","active");
				model.addAttribute("estados", estadoRepository.findAll());
				model.addAttribute("predios", predioRepository.findAll());
				model.addAttribute("potreroList", potreroService.getAllPotreros());
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("potreroForm", potrero);
				model.addAttribute("formTab","active");
				model.addAttribute("estados", estadoRepository.findAll());
				model.addAttribute("predios", predioRepository.findAll());
				model.addAttribute("potreroList", potreroService.getAllPotreros());
			}
			
		}
		
		
		model.addAttribute("estados", estadoRepository.findAll());
		model.addAttribute("predios", predioRepository.findAll());
		model.addAttribute("potreroList", potreroService.getAllPotreros());
		return "potrero-form/potrero-view";
	}

}
