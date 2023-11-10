package com.kleyber.SISGEO.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleyber.SISGEO.dominio.DesaparecimentoPessoa;

public interface DesaparecimentoRepository extends JpaRepository<DesaparecimentoPessoa, Integer>{

}
