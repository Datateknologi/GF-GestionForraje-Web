package com.gestionforraje.web.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.service.PotreroService;


@RestController
@RequestMapping("/api/potrero")
public class PotreroControllerRest {
	
	PotreroService potreroService;
	
	
	public PotreroControllerRest(PotreroService potreroService) {
		this.potreroService = potreroService;
	}
	
	
	@GetMapping
	public ResponseEntity<Iterable<Potrero>> getAllPotreros(){
		Iterable<Potrero> potreros = potreroService.getAllPotreros();
		return new ResponseEntity<>(potreros, HttpStatus.OK);
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Potrero> getPotrero(@PathVariable Long id) throws Exception{
		return new ResponseEntity<>(potreroService.getPotreroById(id), HttpStatus.OK);
	}

}
