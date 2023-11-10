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
import com.kleyber.SISGEO.dominio.Estelionato;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/estelionato")
public class EstelionatoController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody Estelionato estelionato) {
    	estelionato.setUf("DF");
        
        
     
        Servidor servidor = estelionato.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	estelionato.setServidor(null);
        }
        
        Prioridade prioridade = estelionato.getPrioridade();
        if (prioridade != null) {
            
        	estelionato.setPrioridade(prioridade);
        }
        
        Status status = estelionato.getStatus();
        if (status != null) {
            
        	estelionato.setStatus(status);
        }
        
        Cidade cidade = estelionato.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(estelionato.getSetorArea().getId()); 
        estelionato.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(estelionato.getMeioEmpregadoIds());

        
        estelionato.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(estelionato);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


