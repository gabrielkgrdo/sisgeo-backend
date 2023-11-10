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
import com.kleyber.SISGEO.dominio.LesaoCorporal;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/lesao-corporal")
public class LesaoCorporalController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody LesaoCorporal lesaoCorporal) {
    	lesaoCorporal.setUf("DF");
        
        
     
        Servidor servidor = lesaoCorporal.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	lesaoCorporal.setServidor(null);
        }
        
        Prioridade prioridade = lesaoCorporal.getPrioridade();
        if (prioridade != null) {
            
        	lesaoCorporal.setPrioridade(prioridade);
        }
        
        Status status = lesaoCorporal.getStatus();
        if (status != null) {
            
        	lesaoCorporal.setStatus(status);
        }
        
        Cidade cidade = lesaoCorporal.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(lesaoCorporal.getSetorArea().getId()); 
        lesaoCorporal.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(lesaoCorporal.getMeioEmpregadoIds());

        
        lesaoCorporal.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(lesaoCorporal);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


