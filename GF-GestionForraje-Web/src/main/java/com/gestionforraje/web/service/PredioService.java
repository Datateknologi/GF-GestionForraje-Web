package com.gestionforraje.web.service;



import com.gestionforraje.web.entity.Predio;

public interface PredioService {

    public Iterable<Predio> getAllPredios();

	public Predio createPredio(Predio predio) throws Exception;

    public Predio getPredioById(Long id) throws Exception;

    public Predio updatePredio(Predio predio) throws Exception;
    
    public void deletePredio(Long id) throws Exception;

}
