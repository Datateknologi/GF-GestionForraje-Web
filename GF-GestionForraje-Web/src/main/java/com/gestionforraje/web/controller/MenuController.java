package com.gestionforraje.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
	
	@GetMapping("/menuForm")
	public String potreroForm(Model model) {
		
		return "menu/menu-view";
	}

}
