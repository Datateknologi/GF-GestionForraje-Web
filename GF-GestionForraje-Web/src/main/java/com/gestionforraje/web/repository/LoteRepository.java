package com.gestionforraje.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Lote;



@Repository
public interface LoteRepository extends CrudRepository<Lote, Long> {
	public Optional<Lote> findByNombre(String nombre);
}
