package com.kleyber.SISGEO.services.exceptions;

public class ObjetonaoEncontradoException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public ObjetonaoEncontradoException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjetonaoEncontradoException(String message) {
		super(message);
	}
	
	

}
