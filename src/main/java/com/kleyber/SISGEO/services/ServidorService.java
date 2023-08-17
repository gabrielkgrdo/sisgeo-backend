package com.kleyber.SISGEO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Pessoa;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.DTOs.ServidorDTO;
import com.kleyber.SISGEO.repositorios.PessoaRepositorio;
import com.kleyber.SISGEO.repositorios.ServidorRepositorio;
import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;
import com.kleyber.SISGEO.services.exceptions.ViolacaoIntegridadeDadoException;

import jakarta.validation.Valid;

@Service
public class ServidorService {

	@Autowired
	private ServidorRepositorio repositorio;

	@Autowired
	private PessoaRepositorio pessoaRepositorio;

	public Servidor findById(Integer id) {
		Optional<Servidor> objeto = repositorio.findById(id);
		return objeto.orElseThrow(() -> new ObjetonaoEncontradoException("Objeto não encontrado! id: " + id));
	}

	public List<Servidor> findAll() {
		return repositorio.findAll();
	}

	public Servidor create(ServidorDTO objetoDTO) {
		objetoDTO.setId(null);
		validaPorCpfeEmail(objetoDTO);
		Servidor newObj = new Servidor(objetoDTO);
		return repositorio.save(newObj);
	}

	public Servidor update(Integer id, @Valid ServidorDTO objetoDto) {
		objetoDto.setId(id);
		Servidor objetoAntigo = findById(id);
		validaPorCpfeEmail(objetoDto);
		objetoAntigo = new Servidor(objetoDto);
		return repositorio.save(objetoAntigo);
	}

	public void delete(Integer id) {
		Servidor objeto = findById(id);
		if (objeto.getOcorrencias().size() > 0) {
			throw new ViolacaoIntegridadeDadoException("Esse servidor possui um chamado atribuído e não pode ser deletado!");
		}
		repositorio.deleteById(id);

	}

	private void validaPorCpfeEmail(ServidorDTO objetoDTO) {
		Optional<Pessoa> objeto = pessoaRepositorio.findByCpf(objetoDTO.getCpf());
		if (objeto.isPresent() && objeto.get().getId() != objetoDTO.getId()) {
			throw new ViolacaoIntegridadeDadoException("CPF já cadastrado!");
		}

		objeto = pessoaRepositorio.findByEmail(objetoDTO.getEmail());
		if (objeto.isPresent() && objeto.get().getId() != objetoDTO.getId()) {
			throw new ViolacaoIntegridadeDadoException("Email já cadastrado!");
		}
	}
}
