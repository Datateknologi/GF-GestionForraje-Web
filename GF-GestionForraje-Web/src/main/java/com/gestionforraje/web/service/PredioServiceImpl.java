package com.gestionforraje.web.service;

import java.util.Optional;

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

	private boolean checkNombreAvailable(Predio predio) throws Exception{
		Optional<Predio> predioFound = repository.findByNombre(predio.getNombre());
		if(predioFound.isPresent()){
			throw new Exception("El nombre de predio ya existe");
		}
		return true;
	}

	@Override
	public Predio createPredio(Predio predio) throws Exception {
		if(checkNombreAvailable(predio)) {
			predio = repository.save(predio);
		}
		return predio;
	}

}
