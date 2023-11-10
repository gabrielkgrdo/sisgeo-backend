package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.OfensasRaciais;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/ofensas-raciais")
public class OfensasRaciaisController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody OfensasRaciais ofensasRaciais) {
    	ofensasRaciais.setUf("DF");
        
        
     
        Servidor servidor = ofensasRaciais.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	ofensasRaciais.setServidor(null);
        }
        
        Prioridade prioridade = ofensasRaciais.getPrioridade();
        if (prioridade != null) {
            
        	ofensasRaciais.setPrioridade(prioridade);
        }
        
        Status status = ofensasRaciais.getStatus();
        if (status != null) {
            
        	ofensasRaciais.setStatus(status);
        }
        
        Cidade cidade = ofensasRaciais.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(ofensasRaciais.getSetorArea().getId()); 
        ofensasRaciais.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(ofensasRaciais.getMeioEmpregadoIds());

        
        ofensasRaciais.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(ofensasRaciais);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


