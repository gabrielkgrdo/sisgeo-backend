package com.kleyber.SISGEO.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.kleyber.SISGEO.services.exceptions.ObjetonaoEncontradoException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ManipuladorExceptionResouce {

	@ExceptionHandler(ObjetonaoEncontradoException.class)
	public ResponseEntity<ErroPadrao> objetonaoEcontradoException(ObjetonaoEncontradoException ex,
			HttpServletRequest request){
		
		ErroPadrao error = new ErroPadrao(System.currentTimeMillis(), HttpStatus.NOT_FOUND.value(),
				"Objeto não encontrado", ex.getMessage(), request.getRequestURI());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
