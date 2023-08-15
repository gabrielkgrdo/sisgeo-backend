package com.kleyber.SISGEO.services.exceptions;

public class ViolacaoIntegridadeDadoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ViolacaoIntegridadeDadoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ViolacaoIntegridadeDadoException(String message) {
		super(message);
	}
	
	

}
