package com.kleyber.SISGEO.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.repositorios.ServidorRepositorio;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepositorio repositorio;
	
	public Servidor findById(Integer id) {
		Optional<Servidor> objeto = repositorio.findById(id);
		return objeto.orElse(null);
	}
}
