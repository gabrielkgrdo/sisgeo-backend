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
import com.kleyber.SISGEO.dominio.DesaparecimentoPessoa;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/desaparecimento-de-pessoa")
public class DesaparecimentoController {

	@Autowired
    private OcorrenciasService ocorrenciasService;
	
	@Autowired
    private MeioEmpregadoService meioEmpregadoService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createAcidenteTransitoOcorrencia(@RequestBody DesaparecimentoPessoa desaparecimento) {
    	desaparecimento.setUf("DF");
        
        
     
        Servidor servidor = desaparecimento.getServidor();
        if (servidor != null && servidor.getId() == null) {
            
        	desaparecimento.setServidor(null);
        }
        
        Prioridade prioridade = desaparecimento.getPrioridade();
        if (prioridade != null) {
            
        	desaparecimento.setPrioridade(prioridade);
        }
        
        Status status = desaparecimento.getStatus();
        if (status != null) {
            
        	desaparecimento.setStatus(status);
        }
        
        Cidade cidade = desaparecimento.getCidade();
        if (cidade == null) {
            
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(desaparecimento.getSetorArea().getId()); 
        desaparecimento.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(desaparecimento.getMeioEmpregadoIds());

        
        desaparecimento.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(desaparecimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
    }


