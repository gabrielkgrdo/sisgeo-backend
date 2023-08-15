package com.kleyber.SISGEO.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kleyber.SISGEO.dominio.DTOs.ServidorDTO;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Servidor extends Pessoa{

	@JsonIgnore
	@OneToMany(mappedBy = "servidor")
	private List<Ocorrencias> ocorrencias = new ArrayList<>();

	public Servidor() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public Servidor(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO);
	}
	
	public Servidor(ServidorDTO objeto) {
		super();
		this.id = objeto.getId();
		this.nome = objeto.getNome();
		this.cpf = objeto.getCpf();
		this.email = objeto.getEmail();
		this.senha = objeto.getSenha();
		this.perfis = objeto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = objeto.getDataCriacao();
	}

	public List<Ocorrencias> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencias> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
}
