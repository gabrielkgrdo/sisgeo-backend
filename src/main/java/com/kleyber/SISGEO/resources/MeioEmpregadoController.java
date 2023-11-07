package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.repositorios.MeioEmpregadoRepository;

@RestController
@RequestMapping("/meio-empregado")
public class MeioEmpregadoController {

	@Autowired
	private MeioEmpregadoRepository meioEmpregadoRepository;
	
	@GetMapping
    public List<MeioEmpregado> getMeioEmpregado() {
        return meioEmpregadoRepository.findAll();
    }
}
