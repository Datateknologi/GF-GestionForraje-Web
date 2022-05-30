package com.gestionforraje.web.service;




import com.gestionforraje.web.entity.Recorrida;


public interface RecorridaService {
	
	public Iterable<Recorrida> getAllRecorridas();

	public Recorrida createRecorrida(Recorrida recorrida) throws Exception;
	
	public Recorrida getRecorridaById(Long id) throws Exception;

	public Recorrida updateRecorrida(Recorrida recorrida) throws Exception;
	
	

}
