package com.wegneto.springmvc.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.wegneto.springmvc.model.domain.Carro;

@Repository
public class CarroDAO {

	private static List<Carro> carros;

	public CarroDAO() {
	       criarCarros();
	   }

	private void criarCarros() {
		if (carros == null) {
			carros = new ArrayList<Carro>();

			carros.add(new Carro("Focus", "Ford", 2016));
			carros.add(new Carro("Linea", "Fiat", 2014));
			carros.add(new Carro("Jetta", "Volkswagen", 2015));
			carros.add(new Carro("Cruze", "Chevrolet", 2017));
		}
	}

	public List<Carro> getCarros() {
		return carros;
	}

}
