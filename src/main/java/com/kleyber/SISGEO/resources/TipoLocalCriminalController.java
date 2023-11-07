package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.TipoLocalCriminal;
import com.kleyber.SISGEO.repositorios.TipoLocalCriminalRepository;

@RestController
@RequestMapping("/tipo-local-criminal")
public class TipoLocalCriminalController {

	@Autowired
	private TipoLocalCriminalRepository tipoLocalCriminalRepository;
	
	@GetMapping
    public List<TipoLocalCriminal> getLocais() {
        return tipoLocalCriminalRepository.findAll();
    }
}
