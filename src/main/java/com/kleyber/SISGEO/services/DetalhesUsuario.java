package com.kleyber.SISGEO.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Pessoa;
import com.kleyber.SISGEO.repositorios.PessoaRepositorio;
import com.kleyber.SISGEO.security.UsuarioSecurity;

@Service
public class DetalhesUsuario implements UserDetailsService{
	
	@Autowired
	private PessoaRepositorio repositorio;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Pessoa> usuario = repositorio.findByEmail(email);
		if(usuario.isPresent()) {
			return new UsuarioSecurity(usuario.get().getId(), usuario.get().getEmail(), usuario.get().getSenha(), usuario.get().getPerfis());
		}
		throw new UsernameNotFoundException(email);
	}

}
