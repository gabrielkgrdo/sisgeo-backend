package com.kleyber.SISGEO.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Pessoa;
import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.DTOs.UsuarioDTO;
import com.kleyber.SISGEO.repositorios.PessoaRepositorio;
import com.kleyber.SISGEO.repositorios.UsuarioRepositorio;
import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;
import com.kleyber.SISGEO.services.exceptions.ViolacaoIntegridadeDadoException;

import javax.validation.Valid;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepositorio repositorio;

	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	
	@Autowired
	private BCryptPasswordEncoder codificador;

	public Usuario findById(Integer id) {
		Optional<Usuario> objeto = repositorio.findById(id);
		return objeto.orElseThrow(() -> new ObjetonaoEncontradoException("Objeto não encontrado! id: " + id));
	}

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario create(UsuarioDTO objetoDTO) {
		objetoDTO.setId(null);
		objetoDTO.setSenha(codificador.encode(objetoDTO.getSenha()));
		validaPorCpfeEmail(objetoDTO);
		Usuario newObj = new Usuario(objetoDTO);
		return repositorio.save(newObj);
	}

	public Usuario update(Integer id, @Valid UsuarioDTO objetoDto) {
		objetoDto.setId(id);
		Usuario objetoAntigo = findById(id);
		validaPorCpfeEmail(objetoDto);
		objetoAntigo = new Usuario(objetoDto);
		return repositorio.save(objetoAntigo);
	}

	public void delete(Integer id) {
		Usuario objeto = findById(id);
		if (objeto.getOcorrencias().size() > 0) {
			throw new ViolacaoIntegridadeDadoException("Esse Usuario possui um chamado atribuído e não pode ser deletado!");
		}
		repositorio.deleteById(id);

	}

	private void validaPorCpfeEmail(UsuarioDTO objetoDTO) {
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
