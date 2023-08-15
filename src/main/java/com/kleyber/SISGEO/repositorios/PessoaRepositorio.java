package com.kleyber.SISGEO.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleyber.SISGEO.dominio.Pessoa;

public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{

}
