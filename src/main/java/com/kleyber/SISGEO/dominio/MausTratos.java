package com.kleyber.SISGEO.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class MausTratos extends Ocorrencia {
	
	@ManyToMany 
    @JoinTable(
    	    name = "MAUS_TRATOS_MEIOS_EMPREGADOS",
    	    joinColumns = @JoinColumn(name = "ocorrencia_id"),
    	    inverseJoinColumns = @JoinColumn(name = "meio_empregado_id")
    	)
    private List<MeioEmpregado> meioEmpregado;

    
    public List<MeioEmpregado> getMeioEmpregado() {
        return meioEmpregado;
    }

    public void setMeioEmpregado(List<MeioEmpregado> meioEmpregado) {
        this.meioEmpregado = meioEmpregado;
    }

	public MausTratos() {

		TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
		tipoOcorrencia.setId(2L);

		setTipoOcorrencia(tipoOcorrencia);

	}
}