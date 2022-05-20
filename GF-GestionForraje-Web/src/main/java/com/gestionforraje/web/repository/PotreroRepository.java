package com.gestionforraje.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Potrero;

@Repository
public interface PotreroRepository extends CrudRepository<Potrero, Long> {

}
