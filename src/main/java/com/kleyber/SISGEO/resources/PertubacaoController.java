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
import com.kleyber.SISGEO.dominio.Pertubacao;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/pertubacao")
public class PertubacaoController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody Pertubacao pertubacao) {
    	pertubacao.setUf("DF");
        
        
     
        Servidor servidor = pertubacao.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	pertubacao.setServidor(null);
        }
        
        Prioridade prioridade = pertubacao.getPrioridade();
        if (prioridade != null) {
            
        	pertubacao.setPrioridade(prioridade);
        }
        
        Status status = pertubacao.getStatus();
        if (status != null) {
            
        	pertubacao.setStatus(status);
        }
        
        Cidade cidade = pertubacao.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(pertubacao.getSetorArea().getId()); 
        pertubacao.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(pertubacao.getMeioEmpregadoIds());

        
        pertubacao.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(pertubacao);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


