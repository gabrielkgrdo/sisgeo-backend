package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.AcidenteTransito;
import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/acidente-transito")
public class AcidenteTransitoController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody AcidenteTransito acidenteTransito) {
    	acidenteTransito.setUf("DF");
        
        
     
        Servidor servidor = acidenteTransito.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	acidenteTransito.setServidor(null);
        }
        
        Prioridade prioridade = acidenteTransito.getPrioridade();
        if (prioridade != null) {
            
        	acidenteTransito.setPrioridade(prioridade);
        }
        
        Status status = acidenteTransito.getStatus();
        if (status != null) {
            
        	acidenteTransito.setStatus(status);
        }
        
        Cidade cidade = acidenteTransito.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(acidenteTransito.getSetorArea().getId()); 
        acidenteTransito.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(acidenteTransito.getMeioEmpregadoIds());

        
        acidenteTransito.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(acidenteTransito);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


