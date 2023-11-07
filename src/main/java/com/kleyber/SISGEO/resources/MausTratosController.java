package com.kleyber.SISGEO.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.MausTratos;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/maus-tratos")
public class MausTratosController {

	@Autowired
    private OcorrenciasService ocorrenciasService;

    @PostMapping
    public ResponseEntity<Ocorrencia> createMausTratosOcorrencia(@RequestBody MausTratos mausTratos) {
    	mausTratos.setUf("DF");
        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(mausTratos);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }

}
