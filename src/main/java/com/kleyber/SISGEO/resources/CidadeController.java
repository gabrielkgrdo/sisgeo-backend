package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.repositorios.CidadeRepositorio;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	 @Autowired
	    private CidadeRepositorio cidadeRepository;

	    @GetMapping
	    public List<Cidade> getCidades() {
	        return cidadeRepository.findAll();
	    }
}
