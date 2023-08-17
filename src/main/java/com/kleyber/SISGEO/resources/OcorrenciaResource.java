package com.kleyber.SISGEO.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.Ocorrencias;
import com.kleyber.SISGEO.dominio.DTOs.OcorrenciaDTO;
import com.kleyber.SISGEO.services.OcorrenciaService;

@RestController
@RequestMapping(value = "/ocorrencias")
public class OcorrenciaResource {

	@Autowired
	private OcorrenciaService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<OcorrenciaDTO> buscaPeloId(@PathVariable Integer id) {
		Ocorrencias obj = service.bucaPeloId(id);
		return ResponseEntity.ok().body(new OcorrenciaDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<OcorrenciaDTO>> buscarTodasOcorrencias() {
		List<Ocorrencias> lista = service.buscarTodasOcorrencias();
		List<OcorrenciaDTO> listaDTO = lista.stream().map(obj -> new OcorrenciaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
}