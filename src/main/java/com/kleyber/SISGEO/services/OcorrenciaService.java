package com.kleyber.SISGEO.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Ocorrencias;
import com.kleyber.SISGEO.repositorios.OcorrenciasRepositorio;
import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciasRepositorio repositorio;
	
	public Ocorrencias bucaPeloId(Integer id) {
		Optional<Ocorrencias> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjetonaoEncontradoException("Objeto não encontrado! ID:" +id));
	}
}
