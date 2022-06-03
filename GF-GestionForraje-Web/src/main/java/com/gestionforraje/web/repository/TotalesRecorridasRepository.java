package com.gestionforraje.web.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.TotalesRecorridas;
@Repository
public interface TotalesRecorridasRepository extends CrudRepository<TotalesRecorridas, Long> {
	
	public Optional<TotalesRecorridas> findByNumero(Long numero);
	public Optional<TotalesRecorridas> findByFecha(Date fecha);

}
