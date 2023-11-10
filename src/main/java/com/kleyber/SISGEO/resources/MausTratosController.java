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
import com.kleyber.SISGEO.dominio.MausTratos;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/maus-tratos")
public class MausTratosController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createMausTratosOcorrencia(@RequestBody MausTratos mausTratos) {
    	mausTratos.setUf("DF");
        
        
     
        Servidor servidor = mausTratos.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	mausTratos.setServidor(null);
        }
        
        Prioridade prioridade = mausTratos.getPrioridade();
        if (prioridade != null) {
            
        	mausTratos.setPrioridade(prioridade);
        }
        
        Status status = mausTratos.getStatus();
        if (status != null) {
            
        	mausTratos.setStatus(status);
        }
        
        Cidade cidade = mausTratos.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(mausTratos.getSetorArea().getId()); 
        mausTratos.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(mausTratos.getMeioEmpregadoIds());

        
        mausTratos.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(mausTratos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }

