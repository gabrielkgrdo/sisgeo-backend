package com.kleyber.SISGEO.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.kleyber.SISGEO.dominio.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer>{
	
	UserDetails findByEmail(String email);
}
