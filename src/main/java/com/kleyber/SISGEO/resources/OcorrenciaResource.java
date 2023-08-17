package com.kleyber.SISGEO.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kleyber.SISGEO.dominio.Ocorrencias;
import com.kleyber.SISGEO.dominio.DTOs.OcorrenciaDTO;
import com.kleyber.SISGEO.services.OcorrenciaService;

import jakarta.validation.Valid;

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

	@PostMapping
	public ResponseEntity<OcorrenciaDTO> create(@Valid @RequestBody OcorrenciaDTO objDTO) {
		Ocorrencias obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<OcorrenciaDTO> update(@PathVariable Integer id, @Valid @RequestBody OcorrenciaDTO objDTO) {
		Ocorrencias newObj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new OcorrenciaDTO(newObj));
	}
}
