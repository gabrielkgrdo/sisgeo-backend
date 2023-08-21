package com.kleyber.SISGEO.dominio.DTOs;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;

import javax.validation.constraints.NotNull;

public class UsuarioDTO {

	protected Integer id;
	@NotNull(message = "o Nome é obrigatório!")
	protected String nome;
	@NotNull(message = "o CPF é obrigatório!")
	protected String cpf;
	@NotNull(message = "o Email é obrigatório!")
	protected String email;
	@NotNull(message = "a Senha é obrigatório!")
	protected String senha;
	protected Set<Integer> perfis = new HashSet<>();

	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();

	public UsuarioDTO() {
		super();
		addPerfil(Perfil.USUARIO);
	}

	public UsuarioDTO(Usuario objeto) {
		super();
		this.id = objeto.getId();
		this.nome = objeto.getNome();
		this.cpf = objeto.getCpf();
		this.email = objeto.getEmail();
		this.senha = objeto.getSenha();
		this.perfis = objeto.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = objeto.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.enumeradores(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	
	
	
}
