package com.kleyber.SISGEO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.DTOs.ServidorDTO;
import com.kleyber.SISGEO.repositorios.ServidorRepositorio;
import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepositorio repositorio;
	
	public Servidor findById(Integer id) {
		Optional<Servidor> objeto = repositorio.findById(id);
		return objeto.orElseThrow(() -> new ObjetonaoEncontradoException("Objeto não encontrado! id: " + id));
	}

	public List<Servidor> findAll() {
		return repositorio.findAll();
	}

	public Servidor create(ServidorDTO objetoDTO) {
		objetoDTO.setId(null);
		Servidor newObj = new Servidor(objetoDTO);
		return repositorio.save(newObj);
	}

}
