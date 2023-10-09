package com.kleyber.SISGEO.security;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.kleyber.SISGEO.dominio.enumeradores.Perfil;

public class UsuarioSecurity implements UserDetails{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	private String email;
	private String senha;
	private Collection<? extends GrantedAuthority> autoridade;
	
	public UsuarioSecurity(Integer id, String email, String nome, String senha, Set<Perfil> perfis) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.autoridade = perfis.stream().map(perfil -> new SimpleGrantedAuthority(perfil.getDescricao())).collect(Collectors.toSet());
	}

	public Integer getId() {
		return id;
	}
	
	public String getNome() {
	    return nome;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return autoridade;
	}

	@Override
	public String getPassword() {
		return senha;
	}

	@Override
	public String getUsername() {
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
