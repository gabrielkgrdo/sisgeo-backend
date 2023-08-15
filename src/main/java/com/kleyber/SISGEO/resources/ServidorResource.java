package com.kleyber.SISGEO.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.DTOs.ServidorDTO;
import com.kleyber.SISGEO.services.ServidorService;

@RestController
@RequestMapping(value = "/servidores")
public class ServidorResource {

	@Autowired
	private ServidorService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ServidorDTO> findById(@PathVariable Integer id) {
		Servidor objeto = this.service.findById(id);
		return ResponseEntity.ok().body(new ServidorDTO(objeto));
	}
	
	@GetMapping
	public ResponseEntity<List<ServidorDTO>> findAll() {
		List<Servidor> lista = service.findAll();
		List<ServidorDTO> listaDTO = lista.stream().map(objeto -> new ServidorDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}
