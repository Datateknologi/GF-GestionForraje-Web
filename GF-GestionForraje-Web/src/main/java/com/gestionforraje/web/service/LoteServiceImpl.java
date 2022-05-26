package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.entity.Lote;
import com.gestionforraje.web.repository.LoteRepository;


@Service
public class LoteServiceImpl implements LoteService{
	
	@Autowired
	LoteRepository repository;

	@Override
	public Iterable<Lote> getAllLotes() {
		return repository.findAll();
	}

}
