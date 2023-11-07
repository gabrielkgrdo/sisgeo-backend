package com.kleyber.SISGEO.dominio;

import javax.persistence.Entity;

@Entity
public class MausTratos extends Ocorrencia {

	public MausTratos() {

		TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
		tipoOcorrencia.setId(2L);

		setTipoOcorrencia(tipoOcorrencia);

	}
}
