package com.gestionforraje.web.repository;

import java.util.Date;
import java.util.Optional;

import com.gestionforraje.web.entity.TotalesRecorridas;

public interface TotalesRecorridasRepository {
	
	public Optional<TotalesRecorridas> findByNumero(Long numero);
	public Optional<TotalesRecorridas> findByFecha(Date fecha);

}
