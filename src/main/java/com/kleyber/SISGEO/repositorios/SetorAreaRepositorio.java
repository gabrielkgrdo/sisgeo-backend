package com.kleyber.SISGEO.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleyber.SISGEO.dominio.SetorArea;

public interface SetorAreaRepositorio extends JpaRepository<SetorArea, Long>{

	List<SetorArea> findByCidadeId(Long cidadeId);
}
