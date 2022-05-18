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

import com.gestionforraje.web.entity.Predio;
import com.gestionforraje.web.service.PredioService;

@Controller
public class PredioController {
	
	@Autowired
	PredioService predioService;
	
	
	
	@GetMapping("/predioForm")
	 public String predioForm(Model model){
		 model.addAttribute("predioForm", new Predio());
		 model.addAttribute("predioList", predioService.getAllPredios());
		 model.addAttribute("listTab","active");
		 return "predio-form/predio-view";
	 }

	 @PostMapping("/predioForm")
	 public String createPredio(@Valid @ModelAttribute("predioForm")Predio predio, BindingResult result,ModelMap model){
		 if(result.hasErrors()) {
			model.addAttribute("predioForm", predio);
			model.addAttribute("formTab","active");
			
		 }else {
			try {
				predioService.createPredio(predio);
				model.addAttribute("predioForm", new Predio());
				model.addAttribute("listTab","active");
			
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("predioForm", predio);
				model.addAttribute("formTab","active");
				model.addAttribute("predioList", predioService.getAllPredios());
			
			}
		}
		 model.addAttribute("predioList", predioService.getAllPredios());
		 return "predio-form/predio-view";
	 }
	 
	 @GetMapping("/editPredio/{id}")
	 public String getEditPredioForm(Model model, @PathVariable(name = "id")Long id)throws Exception{
		 Predio predioToEdit = predioService.getPredioById(id);
		 
		 model.addAttribute("predioForm", predioToEdit);
		 model.addAttribute("predioList", predioService.getAllPredios());
		 model.addAttribute("formTab","active");
		 model.addAttribute("editMode","true");
		 return "predio-form/predio-view";
	 }

	 @PostMapping("/editPredio")
	 public String postEditPredioForm(@Valid @ModelAttribute("predioForm")Predio predio, BindingResult result,ModelMap model){
		 if(result.hasErrors()) {
			model.addAttribute("predioForm", predio);
			model.addAttribute("formTab","active");
			model.addAttribute("editMode","true");			
		 }else {
			try {
				predioService.updatePredio(predio);
				model.addAttribute("predioForm", new Predio());
				model.addAttribute("listTab","active");
			
			} catch (Exception e) {
				model.addAttribute("formErrorMessage",e.getMessage());
				model.addAttribute("predioForm", predio);
				model.addAttribute("formTab","active");
				model.addAttribute("predioList", predioService.getAllPredios());
				model.addAttribute("editMode","true");
			
			}
		}
		 model.addAttribute("predioList", predioService.getAllPredios());
		 return "predio-form/predio-view";
	 }
	 
	 @GetMapping("/predioForm/cancel")
		public String cancelEditPredio(ModelMap model) {
			return "redirect:/predioForm";
		}
	 
	 @GetMapping("/deletePredio/{id}")
	 public String deletePredio(Model model, @PathVariable(name="id")Long id) {
		 try {
			predioService.deletePredio(id);
		} catch (Exception e) {
			model.addAttribute("listErrorMessage",e.getMessage());
		}
		 return "redirect:/predioForm";
	 }
	
}
