package com.kleyber.SISGEO.repositorios;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kleyber.SISGEO.dominio.Pessoa;


public interface PessoaRepositorio extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}
