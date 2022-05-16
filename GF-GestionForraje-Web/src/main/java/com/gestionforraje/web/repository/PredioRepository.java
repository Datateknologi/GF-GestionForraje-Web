package com.gestionforraje.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Predio;

@Repository
public interface PredioRepository extends CrudRepository<Predio, Long>{

}
