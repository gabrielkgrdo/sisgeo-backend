package com.kleyber.SISGEO.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kleyber.SISGEO.dominio.Cidade;

@Repository
public interface CidadeRepositorio extends JpaRepository<Cidade, Long> {

}
