package com.gestionforraje.web.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class RecorridaController {
	
	@GetMapping("/recorridaForm")
	public String recorridaForm() {
		return "recorrida-form/recorrida-view";
	}

}
