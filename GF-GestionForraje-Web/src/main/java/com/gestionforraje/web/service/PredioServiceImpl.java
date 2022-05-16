package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.entity.Predio;
import com.gestionforraje.web.repository.PredioRepository;

@Service
public class PredioServiceImpl implements PredioService{
	
	@Autowired
	PredioRepository repository;

	@Override
	public Iterable<Predio> getAllPredios() {
		return repository.findAll();
	}

}
