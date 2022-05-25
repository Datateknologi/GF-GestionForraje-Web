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
import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.entity.Predio;
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
	
	 @GetMapping("/editPotrero/{id}")
	 public String getEditPotreroForm(Model model, @PathVariable(name = "id")Long id)throws Exception{
		 Potrero potreroToEdit = potreroService.getPotreroById(id);
		 
		 model.addAttribute("potreroForm", potreroToEdit);
		 model.addAttribute("estados", estadoRepository.findAll());
		 model.addAttribute("predios", predioRepository.findAll());
		 model.addAttribute("potreroList", potreroService.getAllPotreros());
		 model.addAttribute("formTab","active");
		 model.addAttribute("editMode","true");
		 return "potrero-form/potrero-view";
	 }

	 @PostMapping("/editPotrero")
	 public String postEditPotreroForm(@Valid @ModelAttribute("potreroForm")Potrero potrero, BindingResult result,ModelMap model){
		 if(result.hasErrors()) {
			model.addAttribute("potreroForm", potrero);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");			
		 }else {
			try {
				potreroService.updatePotrero(potrero);
				model.addAttribute("potreroForm", new Potrero());
				model.addAttribute("listTab","active");
			
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("potreroForm", potrero);
				model.addAttribute("formTab","active");
				model.addAttribute("estados", estadoRepository.findAll());
				model.addAttribute("predios", predioRepository.findAll());
				model.addAttribute("potreroList", potreroService.getAllPotreros());
				model.addAttribute("editMode","true");
			
			}
		}
		 model.addAttribute("estados", estadoRepository.findAll());
		 model.addAttribute("predios", predioRepository.findAll());
		 model.addAttribute("potreroList", potreroService.getAllPotreros());
		 return "potrero-form/potrero-view";
	 }
	
	 @GetMapping("/potreroForm/cancel")
		public String cancelEditPotrero(ModelMap model) {
			return "redirect:/potreroForm";
		}
	
	 @GetMapping("/deletePotrero/{id}")
	 public String deletePotrero(Model model, @PathVariable(name="id")Long id) {
		 try {
			potreroService.deletePotrero(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		 return "redirect:/potreroForm";
	 }
	

}
