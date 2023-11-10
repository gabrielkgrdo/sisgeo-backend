package com.kleyber.SISGEO.dominio;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

@Entity
public class Furto extends Ocorrencia{
	
	    @ManyToMany 
	    @JoinTable(
	    	    name = "FURTO_MEIOS_EMPREGADOS",
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
	
	public Furto() {
		
        TipoOcorrencia tipoOcorrencia = new TipoOcorrencia();
        tipoOcorrencia.setId(4L);
        
        
        setTipoOcorrencia(tipoOcorrencia);
        
        
    
    }
}
