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
import com.gestionforraje.web.entity.Lote;
import com.gestionforraje.web.repository.PredioRepository;
import com.gestionforraje.web.service.LoteService;

@Controller
public class LoteController {
	
	@Autowired
	PredioRepository predioRepository;
	
	@Autowired
	LoteService loteService;
	
	
	@GetMapping("/loteForm")
	public String potreroForm(Model model) {
		model.addAttribute("loteForm", new Lote());
		model.addAttribute("predios", predioRepository.findAll());
		model.addAttribute("loteList", loteService.getAllLotes());
		model.addAttribute("listTab","active");
		return "lote-form/lote-view";
	}

	@PostMapping("/loteForm")
	public String createLote(@Valid @ModelAttribute("loteForm")Lote lote, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("loteForm", lote);
			model.addAttribute("formTab","active");
		}else {
			try {
				loteService.createLote(lote);
				model.addAttribute("loteForm", new Lote());
				model.addAttribute("listTab","active");
				
			}catch (CustomeFieldValidationException cfve) {
				result.rejectValue(cfve.getFieldName(),null,cfve.getMessage());
				model.addAttribute("loteForm", lote);
				model.addAttribute("formTab","active");
				model.addAttribute("lotes", predioRepository.findAll());
				model.addAttribute("loteList", loteService.getAllLotes());
			
			
			}catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("loteForm", lote);
				model.addAttribute("formTab","active");
				model.addAttribute("predios", predioRepository.findAll());
				model.addAttribute("loteList", loteService.getAllLotes());
			}
			
		}
		
		
		
		model.addAttribute("predios", predioRepository.findAll());
		model.addAttribute("loteList", loteService.getAllLotes());
		return "lote-form/lote-view";
	}
	
	

}
