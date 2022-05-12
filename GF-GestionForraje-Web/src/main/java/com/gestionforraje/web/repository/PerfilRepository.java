package com.gestionforraje.web.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gestionforraje.web.entity.Perfil;

@Repository
public interface PerfilRepository extends CrudRepository<Perfil, Long>{

}
