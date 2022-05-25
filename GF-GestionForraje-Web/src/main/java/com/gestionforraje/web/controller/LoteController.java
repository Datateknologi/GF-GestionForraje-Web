package com.gestionforraje.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoteController {
	
	@GetMapping("/loteForm")
	public String potreroForm() {
		
		return "lote-form/lote-view";
	}

}
