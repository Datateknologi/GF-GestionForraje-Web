package com.gestionforraje.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
