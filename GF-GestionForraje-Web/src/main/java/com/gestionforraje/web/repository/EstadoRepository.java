package com.gestionforraje.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Estado;



@Repository
public interface EstadoRepository extends CrudRepository<Estado, Long>{

}
