package com.kleyber.SISGEO.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.repositorios.CidadeRepositorio;

@Service
public class CidadeService {

	@Autowired
    private CidadeRepositorio cidadeRepository;

    public Cidade findById(Long id) {
        Optional<Cidade> cidadeOptional = cidadeRepository.findById(id);
        return cidadeOptional.orElse(null);
    }
}
