package com.kleyber.SISGEO.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErroValidation extends ErroPadrao{

	private List<MenssagemdeCampo> erros = new ArrayList<>();

	public ErroValidation() {
		super();
	}

	public ErroValidation(Long timestamp, Integer satus, String error, String message, String path) {
		super(timestamp, satus, error, message, path);
	}

	public List<MenssagemdeCampo> getErros() {
		return erros;
	}

	public void addErros (String nomeCampo, String menssagem) {
		this.erros.add(new MenssagemdeCampo(nomeCampo, menssagem));
	}
	
	
}
