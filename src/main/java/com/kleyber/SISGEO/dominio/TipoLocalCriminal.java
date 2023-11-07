package com.kleyber.SISGEO.dominio;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TipoLocalCriminal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nomeLocal;
	
	public TipoLocalCriminal() {
		super();
	}
	
	

	public TipoLocalCriminal(Long id, String nomeLocal) {
		super();
		this.id = id;
		this.nomeLocal = nomeLocal;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeLocal() {
		return nomeLocal;
	}

	public void setNomeLocal(String nomeLocal) {
		this.nomeLocal = nomeLocal;
	}
	
	
}
