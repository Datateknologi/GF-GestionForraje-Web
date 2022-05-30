package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.entity.Recorrida;
import com.gestionforraje.web.repository.RecorridaRepository;

@Service
public class RecorridaServiceImpl implements RecorridaService{
	
	@Autowired
	RecorridaRepository repository;

	@Override
	public Iterable<Recorrida> getAllRecorridas() {
		return repository.findAll();
		
	}


	@Override
	public Recorrida createRecorrida(Recorrida recorrida) throws Exception {
		recorrida = repository.save(recorrida);
		return recorrida;
	}

}
