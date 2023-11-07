package com.kleyber.SISGEO.dominio.DTOs;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.dominio.MariaDaPenha;
import com.kleyber.SISGEO.dominio.SetorArea;

public class MariaDaPenhaDTO {
    
	private Integer id;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo dataInicioFato é Obrigatório!" )
    private LocalDate dataInicioFato;
    
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "O campo horaInicioFato é Obrigatório!" )
    private LocalTime horaInicioFato;
    
    @JsonFormat(pattern = "dd/MM/yyyy")
    @NotNull(message = "O campo dataFimFato é Obrigatório!" )
    private LocalDate dataFimFato;
    
    @JsonFormat(pattern = "HH:mm")
    @NotNull(message = "O campo horaFimFato é Obrigatório!" )
    private LocalTime horaFimFato;
    
    private String ufFato;
    
    @JsonProperty("cidadeFatoNome")
    private String cidadeFatoNome;
    
    private Cidade cidadeFato;
    private SetorArea setorArea;
    private String quadra;
    private String complemento;
    private String tipoLocalCriminal;
    private String descricaoLocal;
    private String meioEmpregado;

    public MariaDaPenhaDTO() {
        super();
    }

	public MariaDaPenhaDTO(MariaDaPenha mariaDaPenha) {
		super();
		this.id = mariaDaPenha.getId();
		this.dataInicioFato = mariaDaPenha.getDataInicioFato();
		this.horaInicioFato = mariaDaPenha.getHoraInicioFato();
		this.dataFimFato = mariaDaPenha.getDataFimFato();
		this.horaFimFato =  mariaDaPenha.getHoraFimFato();
		this.ufFato = mariaDaPenha.getUfFato();
		this.cidadeFato = mariaDaPenha.getCidadeFato();
		this.setorArea = mariaDaPenha.getSetorArea();
		this.quadra = mariaDaPenha.getQuadra();
		this.complemento = mariaDaPenha.getComplemento();
		this.tipoLocalCriminal = mariaDaPenha.getTipoLocalCriminal();
		this.descricaoLocal = mariaDaPenha.getDescricaoLocal();
		this.meioEmpregado = mariaDaPenha.getMeioEmpregado();
	}
	
	

	

	public String getCidadeFatoNome() {
		return cidadeFatoNome;
	}

	public void setCidadeFatoNome(String cidadeFatoNome) {
		this.cidadeFatoNome = cidadeFatoNome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataInicioFato() {
		return dataInicioFato;
	}

	public void setDataInicioFato(LocalDate dataInicioFato) {
		this.dataInicioFato = dataInicioFato;
	}

	public LocalTime getHoraInicioFato() {
		return horaInicioFato;
	}

	public void setHoraInicioFato(LocalTime horaInicioFato) {
		this.horaInicioFato = horaInicioFato;
	}

	public LocalDate getDataFimFato() {
		return dataFimFato;
	}

	public void setDataFimFato(LocalDate dataFimFato) {
		this.dataFimFato = dataFimFato;
	}

	public LocalTime getHoraFimFato() {
		return horaFimFato;
	}

	public void setHoraFimFato(LocalTime horaFimFato) {
		this.horaFimFato = horaFimFato;
	}

	public String getUfFato() {
		return ufFato;
	}

	public void setUfFato(String ufFato) {
		this.ufFato = ufFato;
	}

	public Cidade getCidadeFato() {
		return cidadeFato;
	}

	public void setCidadeFato(Cidade cidadeFato) {
		this.cidadeFato = cidadeFato;
	}

	public SetorArea getSetorArea() {
		return setorArea;
	}

	public void setSetorArea(SetorArea setorArea) {
		this.setorArea = setorArea;
	}

	public String getQuadra() {
		return quadra;
	}

	public void setQuadra(String quadra) {
		this.quadra = quadra;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getTipoLocalCriminal() {
		return tipoLocalCriminal;
	}

	public void setTipoLocalCriminal(String tipoLocalCriminal) {
		this.tipoLocalCriminal = tipoLocalCriminal;
	}

	public String getDescricaoLocal() {
		return descricaoLocal;
	}

	public void setDescricaoLocal(String descricaoLocal) {
		this.descricaoLocal = descricaoLocal;
	}

	public String getMeioEmpregado() {
		return meioEmpregado;
	}

	public void setMeioEmpregado(String meioEmpregado) {
		this.meioEmpregado = meioEmpregado;
	}

   

    
}
