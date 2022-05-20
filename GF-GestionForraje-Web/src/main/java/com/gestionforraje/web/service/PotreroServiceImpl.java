package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.repository.PotreroRepository;

@Service
public class PotreroServiceImpl implements PotreroService{
	
	@Autowired
	PotreroRepository repository;

	@Override
	public Iterable<Potrero> getAllPotreros() {
		return repository.findAll();
	}

}
