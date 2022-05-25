package com.gestionforraje.web.service;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.entity.Predio;
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
	
	
	@Override
	public Potrero getPotreroById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El Potrero no existe"));
	}
	
	@Override
	public Potrero updatePotrero(Potrero fromPotrero) throws Exception {
		Potrero toPotrero = getPotreroById(fromPotrero.getId());
		mapPotrero(fromPotrero, toPotrero);
		return repository.save(toPotrero);
	}
	
	protected void mapPotrero(Potrero from,Potrero to) {
		to.setNombre(from.getNombre());
		to.setAreaHa(from.getAreaHa());
		to.setPastura(from.getPastura());
		to.setEstado(from.getEstado());
		to.setPredio(from.getPredio());
		to.setObservaciones(from.getObservaciones());	
	}
	
	@Override
	public void deletePotrero(Long id) throws Exception {
		Potrero potrero = getPotreroById(id);
		repository.delete(potrero);
		
	}
	
	
}
