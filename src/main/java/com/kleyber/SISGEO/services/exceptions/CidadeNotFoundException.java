package com.kleyber.SISGEO.services.exceptions;

public class CidadeNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CidadeNotFoundException(String message) {
        super(message);
    }
}
