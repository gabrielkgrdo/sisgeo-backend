package com.kleyber.SISGEO.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.repositorios.SetorAreaRepositorio;

@Service
public class SetorService {

	@Autowired
    private SetorAreaRepositorio setorRepositorio; 

    public List<SetorArea> getSetoresPorCidade(Long cidadeId) {
        
        return setorRepositorio.findByCidadeId(cidadeId); 
    }
}
