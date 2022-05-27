package com.gestionforraje.web.service;

import com.gestionforraje.web.entity.Lote;


public interface LoteService {
	public Iterable<Lote> getAllLotes();

	public Lote createLote(Lote lote) throws Exception;
}
