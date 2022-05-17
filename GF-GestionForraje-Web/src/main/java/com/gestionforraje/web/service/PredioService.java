package com.gestionforraje.web.service;

import javax.validation.Valid;

import com.gestionforraje.web.entity.Predio;

public interface PredioService {

    public Iterable<Predio> getAllPredios();

	public Predio createPredio(Predio predio) throws Exception;

}
