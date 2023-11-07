package com.kleyber.SISGEO.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SetorArea {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	 
	 private String nome;
	 
	 @ManyToOne
	 @JoinColumn(name = "cidade_id")
	 @JsonIgnore
	 private Cidade cidade;

	 
	 
	public SetorArea() {
		super();
		
	}
	
	

	public SetorArea(Long id, String nome, Cidade cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.cidade = cidade;
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}
	 
	 
	 
	   
	}

