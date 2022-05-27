package com.gestionforraje.web.service;

import javax.validation.Valid;

import com.gestionforraje.web.entity.Lote;



public interface LoteService {
	
	public Iterable<Lote> getAllLotes();

	public Lote createLote(Lote lote) throws Exception;
	
	public Lote getLoteById(Long id) throws Exception;

	public Lote updateLote(Lote lote) throws Exception;

	public void deleteLote(Long id) throws Exception;
}
