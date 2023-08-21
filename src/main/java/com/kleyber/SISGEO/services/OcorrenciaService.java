package com.kleyber.SISGEO.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Ocorrencias;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.DTOs.OcorrenciaDTO;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.repositorios.OcorrenciasRepositorio;
import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;

@Service
public class OcorrenciaService {

	@Autowired
	private OcorrenciasRepositorio repositorio;

	@Autowired
	private ServidorService servidorService;

	@Autowired
	private UsuarioService usuarioService;

	public Ocorrencias bucaPeloId(Integer id) {
		Optional<Ocorrencias> obj = repositorio.findById(id);
		return obj.orElseThrow(() -> new ObjetonaoEncontradoException("Objeto não encontrado! ID:" + id));
	}

	public List<Ocorrencias> buscarTodasOcorrencias() {
		return repositorio.findAll();
	}

	public Ocorrencias create(@Valid OcorrenciaDTO objDTO) {
		return repositorio.save(newOcorrencia(objDTO));
	}
	
	public Ocorrencias update(@Valid Integer id, OcorrenciaDTO objDTO) {
		objDTO.setId(id);
		Ocorrencias objetoAntigo = bucaPeloId(id);
		objetoAntigo = newOcorrencia(objDTO);
		return repositorio.save(objetoAntigo);
	}

	private Ocorrencias newOcorrencia(OcorrenciaDTO obj) {
		Servidor servidor = servidorService.findById(obj.getServidor());
		Usuario usuario = usuarioService.findById(obj.getUsuario());

		Ocorrencias ocorrencia = new Ocorrencias();
		if (obj.getId() != null) {
			ocorrencia.setId(obj.getId());
		}
		
		if(obj.getStatus().equals(2)) {
			ocorrencia.setDataFechamento(LocalDate.now());
		}

		ocorrencia.setServidor(servidor);
		ocorrencia.setUsuario(usuario);
		ocorrencia.setPrioridade(Prioridade.enumeradores(obj.getPrioridade()));
		ocorrencia.setStatus(Status.enumeradores(obj.getStatus()));
		ocorrencia.setTitulo(obj.getTitulo());
		ocorrencia.setDescricaoOcorrencia(obj.getDescricaoOcorrencia());
		return ocorrencia;
	}

	
}
