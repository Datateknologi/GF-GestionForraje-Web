package com.gestionforraje.web.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Predio;

@Repository
public interface PredioRepository extends CrudRepository<Predio, Long>{

    public Optional<Predio> findByNombre(String nombre);
}
