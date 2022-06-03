package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.gestionforraje.web.entity.TotalesRecorridas;
import com.gestionforraje.web.repository.TotalesRecorridasRepository;

@Service
public class TotalesRecorridasServiceImpl implements TotalesRecorridasService {
	
	@Autowired
	TotalesRecorridasRepository repository;

	@Override
	public Iterable<TotalesRecorridas> getAllTotalesRecorridas() {
		
		return repository.findAll();
	}

}
