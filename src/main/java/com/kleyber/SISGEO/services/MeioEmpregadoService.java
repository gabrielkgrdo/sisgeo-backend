package com.kleyber.SISGEO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.repositorios.MeioEmpregadoRepository;

@Service
public class MeioEmpregadoService {
	
	@Autowired
    private MeioEmpregadoRepository meioEmpregadoRepository; 
    public List<MeioEmpregado> buscarMeioEmpregadoPorIds(List<Long> meioEmpregadoIds) {
        return meioEmpregadoRepository.findAllById(meioEmpregadoIds);
    }

}
