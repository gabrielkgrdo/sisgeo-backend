package com.kleyber.SISGEO.dominio;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kleyber.SISGEO.dominio.DTOs.UsuarioDTO;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario extends Pessoa implements UserDetails{

	private static final long serialVersionUID = 1L;
	@JsonIgnore
	@OneToMany(mappedBy = "usuario")
	private List<Ocorrencias> ocorrencias = new ArrayList<>();

	public Usuario() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public Usuario(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.USUARIO);
	}
	
	public Usuario(UsuarioDTO objeto) {
		super();
		this.id = objeto.getId();
		this.nome = objeto.getNome();
		this.cpf = objeto.getCpf();
		this.email = objeto.getEmail();
		this.senha = objeto.getSenha();
		this.perfis = objeto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = objeto.getDataCriacao();
	}

	public List<Ocorrencias> getOcorrencias() {
		return ocorrencias;
	}

	public void setOcorrencias(List<Ocorrencias> ocorrencias) {
		this.ocorrencias = ocorrencias;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if(this.perfis.add(addPerfil(Perfil.ADMIN))) return List.of(new SimpleGrantedAuthority("PERFIL_ADMIN"), new SimpleGrantedAuthority("PERFIL_USUARIO"));
		else return List.of(new SimpleGrantedAuthority("PERFIL_USUARIO"));
	}

	@Override
	public String getPassword() {
		return email;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}
	
	
}
