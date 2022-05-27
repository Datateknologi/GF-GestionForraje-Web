package com.gestionforraje.web.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.Exeption.CustomeFieldValidationException;
import com.gestionforraje.web.entity.Lote;
import com.gestionforraje.web.entity.Potrero;
import com.gestionforraje.web.repository.LoteRepository;


@Service
public class LoteServiceImpl implements LoteService{
	
	@Autowired
	LoteRepository repository;

	@Override
	public Iterable<Lote> getAllLotes() {
		return repository.findAll();
	}
	
	
	private boolean checkNombreAvailable(Lote lote) throws Exception {
		Optional<Lote> loteFound = repository.findByNombre(lote.getNombre());
		if(loteFound.isPresent()) {
			throw new CustomeFieldValidationException("El nombre del lote ya existe","nombre");
		}
		return true;
	}
	
	

	@Override
	public Lote createLote(Lote lote) throws Exception {
		if(checkNombreAvailable(lote)) {
			lote = repository.save(lote);
		}
		return lote;
	}


	@Override
	public Lote getLoteById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("El Lote no existe"));

	}


	@Override
	public Lote updateLote(Lote fromLote) throws Exception {
		Lote toLote = getLoteById(fromLote.getId());
		mapLote(fromLote, toLote);
		return repository.save(toLote);
	}
	
	protected void mapLote(Lote from,Lote to) {
		to.setNombre(from.getNombre());
		to.setFecha(from.getFecha());
		to.setnAnimales(from.getnAnimales());
		to.setConsumoForrajeAnimal(from.getConsumoForrajeAnimal());;
		to.setPredio(from.getPredio());
		to.setObservaciones(from.getObservaciones());	
	}
	

}
