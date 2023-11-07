package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.services.SetorService;

@RestController
@RequestMapping("/setores")
public class SetorAreaController {

	 @Autowired
	    private SetorService setorService;

	    @GetMapping("/cidade/{cidadeId}")
	    public ResponseEntity<List<SetorArea>> getSetoresByCidade(@PathVariable Long cidadeId) {
	        List<SetorArea> setores = setorService.getSetoresPorCidade(cidadeId);
	        return ResponseEntity.ok(setores);
	    }
}
