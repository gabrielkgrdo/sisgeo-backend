package com.kleyber.SISGEO.dominio;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cidade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	
	@OneToMany(mappedBy = "cidade")
	@JsonIgnore
	private Set<SetorArea> setores;

	
	
	public Cidade() {
		super();
		
	}
	

	public Cidade(Long id, String nome, Set<SetorArea> setores) {
		super();
		this.id = id;
		this.nome = nome;
		this.setores = setores;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<SetorArea> getSetores() {
		return setores;
	}

	public void setSetores(Set<SetorArea> setores) {
		this.setores = setores;
	}
	
	
}
