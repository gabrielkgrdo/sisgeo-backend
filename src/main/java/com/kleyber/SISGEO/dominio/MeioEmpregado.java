package com.kleyber.SISGEO.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MeioEmpregado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeMeioEmpregado;
	
	
	public MeioEmpregado() {
		super();
	}


	public MeioEmpregado(Long id, String nomeMeioEmpregado) {
		super();
		this.id = id;
		this.nomeMeioEmpregado = nomeMeioEmpregado;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNomeMeioEmpregado() {
		return nomeMeioEmpregado;
	}


	public void setNomeMeioEmpregado(String nomeMeioEmpregado) {
		this.nomeMeioEmpregado = nomeMeioEmpregado;
	}
	
	
	
}
