package com.gestionforraje.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Potrero;


@Repository
public interface PotreroRepository extends CrudRepository<Potrero, Long> {
	public Optional<Potrero> findByNombre(String nombre);
}
