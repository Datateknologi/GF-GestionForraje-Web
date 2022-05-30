package com.gestionforraje.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gestionforraje.web.Exeption.UsernameOrIdNotFound;
import com.gestionforraje.web.entity.Recorrida;
import com.gestionforraje.web.entity.Usuario;
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


	@Override
	public Recorrida getRecorridaById(Long id) throws Exception {
		return repository.findById(id).orElseThrow(()-> new Exception("El Id de la Recorrida no existe"));
	}


	@Override
	public Recorrida updateRecorrida(Recorrida fromRecorrida) throws Exception {
		Recorrida toRecorrida = getRecorridaById(fromRecorrida.getId());
		mapRecorrida(fromRecorrida, toRecorrida);
		return repository.save(toRecorrida);
		
	}
	
	protected void mapRecorrida(Recorrida from,Recorrida to) {
		to.setFecha(from.getFecha());
		to.setPotrero(from.getPotrero());
		to.setKgMsHa(from.getKgMsHa());
		to.setHojas(from.getHojas());
		to.setNudos(from.getNudos());
		to.setObservaciones(from.getObservaciones());
	
	}

}
