package com.gestionforraje.web.repository;

import java.util.Date;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Recorrida;
@Repository
public interface RecorridaRepository extends CrudRepository<Recorrida, Long> {
	public Optional<Recorrida> findByFecha(Date fecha);
}
