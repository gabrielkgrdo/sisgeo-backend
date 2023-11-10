package com.kleyber.SISGEO.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class LesaoCorporal extends Ocorrencia{
	
	    @ManyToMany 
	    @JoinTable(
	    	    name = "LESAO_CORPORAL_MEIOS_EMPREGADOS",
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
	
	public LesaoCorporal() {
		
        TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
        tipoOcorrencia.setId(9L);
        
        
        setTipoOcorrencia(tipoOcorrencia);
        
        
    
    }
}
