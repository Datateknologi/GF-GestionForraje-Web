package com.gestionforraje.web.service;

import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.entity.Predio;


public interface PotreroService {
	
	public Iterable<Potrero> getAllPotreros();

	public Potrero createPotrero(Potrero potrero) throws Exception;
	
	public Potrero getPotreroById(Long id) throws Exception;
	
	public Potrero updatePotrero(Potrero potrero) throws Exception;

	public void deletePotrero(Long id) throws Exception;
}
