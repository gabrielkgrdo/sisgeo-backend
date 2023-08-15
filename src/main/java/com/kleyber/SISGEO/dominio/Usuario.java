package com.kleyber.SISGEO.dominio;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends Pessoa {

	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Ocorrencias> ocorrencias = new ArrayList<>();

	public Usuario() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public Usuario(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO);
	}

	public List<Ocorrencias> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencias> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}
	
	
}
