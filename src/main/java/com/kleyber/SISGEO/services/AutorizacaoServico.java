package com.kleyber.SISGEO.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.repositorios.UsuarioRepositorio;

@Service
public class AutorizacaoServico implements UserDetailsService{

	@Autowired
	UsuarioRepositorio repositorio;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return repositorio.findByEmail(username);
	}

}
