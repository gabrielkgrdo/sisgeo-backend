package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.Ameaca;
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
@RequestMapping("/ameaca")
public class AmeacaController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody Ameaca ameaca) {
    	ameaca.setUf("DF");
        
        
     
        Servidor servidor = ameaca.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	ameaca.setServidor(null);
        }
        
        Prioridade prioridade = ameaca.getPrioridade();
        if (prioridade != null) {
            
        	ameaca.setPrioridade(prioridade);
        }
        
        Status status = ameaca.getStatus();
        if (status != null) {
            
        	ameaca.setStatus(status);
        }
        
        Cidade cidade = ameaca.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(ameaca.getSetorArea().getId()); 
        ameaca.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(ameaca.getMeioEmpregadoIds());

        
        ameaca.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(ameaca);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


