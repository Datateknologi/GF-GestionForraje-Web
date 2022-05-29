package com.gestionforraje.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.gestionforraje.web.entity.Recorrida;
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

}
