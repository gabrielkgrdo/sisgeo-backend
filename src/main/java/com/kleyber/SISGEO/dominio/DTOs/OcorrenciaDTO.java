package com.kleyber.SISGEO.dominio.DTOs;

public class OcorrenciaDTO {
    private Integer id;
    private String tipoOcorrenciaNome;

    public OcorrenciaDTO(Integer id, String tipoOcorrenciaNome) {
        this.id = id;
        this.tipoOcorrenciaNome = tipoOcorrenciaNome;
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipoOcorrenciaNome() {
		return tipoOcorrenciaNome;
	}

	public void setTipoOcorrenciaNome(String tipoOcorrenciaNome) {
		this.tipoOcorrenciaNome = tipoOcorrenciaNome;
	}

    
}
