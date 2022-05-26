package com.gestionforraje.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

}
