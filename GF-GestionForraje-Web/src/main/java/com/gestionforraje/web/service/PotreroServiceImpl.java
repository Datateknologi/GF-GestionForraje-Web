package com.gestionforraje.web.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
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
	
	private boolean checkNombreAvailable(Potrero potrero) throws Exception {
		Optional<Potrero> potreroFound = repository.findByNombre(potrero.getNombre());
		if(potreroFound.isPresent()) {
			throw new CustomeFieldValidationException("El nombre de potrero ya existe","nombre");
		}
		return true;
	}

	@Override
	public Potrero createPotrero(Potrero potrero) throws Exception {
		if(checkNombreAvailable(potrero)) {
			potrero = repository.save(potrero);
		}
		return potrero;
	}
	
	
}
