 package com.kleyber.SISGEO.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.DTOs.UsuarioDTO;
import com.kleyber.SISGEO.services.UsuarioService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
		Usuario objeto = this.service.findById(id);
		return ResponseEntity.ok().body(new UsuarioDTO(objeto));
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> lista = service.findAll();
		List<UsuarioDTO> listaDTO = lista.stream().map(objeto -> new UsuarioDTO(objeto)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listaDTO);
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> create(@Valid @RequestBody UsuarioDTO objetoDTO) {
		Usuario newObjeto = service.create(objetoDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObjeto.getId()).toUri();	
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @Valid @RequestBody UsuarioDTO objetoDto){
		Usuario objeto = service.update(id, objetoDto);
		return ResponseEntity.ok().body(new UsuarioDTO(objeto));
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
