package com.gestionforraje.web.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.entity.TotalesRecorridas;



@Controller
public class TotalesRecorridasController {
	
	@GetMapping("/totalesRecorridasForm")
	public String recorridaForm() {
		
		return "totalesRecorridas-form/totalesRecorridas-view";
	}
	
	/*
	@PostMapping("/totalesRecorridasForm")
	public String createPotrero(@Valid @ModelAttribute("totalesRecorridasForm")TotalesRecorridas totalesrecorridas, BindingResult result, ModelMap model){
		if(result.hasErrors()){
			model.addAttribute("totalesRecorridasForm", totalesRecorridas);
			model.addAttribute("formTab","active");
		}else {
			try {
				totalesRecorridasService.createtotalesRecorridas(totalesRecorridas);
				model.addAttribute("totalesRecorridasForm", new TotalesRecorridas());
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
				model.addAttribute("totalesRecorridasForm", totalesRecorridas);
				model.addAttribute("formTab","active");
				model.addAttribute("totalesRecorridasList", totalesRecorridasService.getAllTotalesRecorridas());
			}
			
		}*/

}
