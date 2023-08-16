package com.kleyber.SISGEO.resources.exceptions;

public class MenssagemdeCampo {

	private String campoNome;
	private String menssagem;

	public MenssagemdeCampo() {
		super();
	}

	public MenssagemdeCampo(String campoNome, String menssagem) {
		super();
		this.campoNome = campoNome;
		this.menssagem = menssagem;
	}

	public String getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(String campoNome) {
		this.campoNome = campoNome;
	}

	public String getMenssagem() {
		return menssagem;
	}

	public void setMenssagem(String menssagem) {
		this.menssagem = menssagem;
	}

}
