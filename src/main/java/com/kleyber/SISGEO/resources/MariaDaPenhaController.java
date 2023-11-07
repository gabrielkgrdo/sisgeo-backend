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
import com.kleyber.SISGEO.dominio.MariaDaPenha;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.services.MeioEmpregadoService;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/maria-da-penha")
public class MariaDaPenhaController {

    @Autowired
    private OcorrenciasService ocorrenciasService;

    @Autowired
    private MeioEmpregadoService meioEmpregadoService; 

    @PostMapping
    public ResponseEntity<Ocorrencia> createMariaDaPenhaOcorrencia(@RequestBody MariaDaPenha mariaDaPenha) {
        mariaDaPenha.setUf("DF");
        
     // Verifique se o ID do servidor foi passado na solicitação
        Servidor servidor = mariaDaPenha.getServidor();
        if (servidor != null && servidor.getId() == null) {
            // Se o ID do servidor não foi especificado, defina-o como nulo
            mariaDaPenha.setServidor(null);
        }
        
        Prioridade prioridade = mariaDaPenha.getPrioridade();
        if (prioridade != null) {
            // Se o ID do servidor não foi especificado, defina-o como nulo
            mariaDaPenha.setPrioridade(prioridade);
        }
        
        Status status = mariaDaPenha.getStatus();
        if (status != null) {
            // Se o ID do servidor não foi especificado, defina-o como nulo
            mariaDaPenha.setStatus(status);
        }
        
        Cidade cidade = mariaDaPenha.getCidade();
        if (cidade == null) {
            // Lançar uma exceção indicando que a cidade não pode ser nula
            throw new IllegalArgumentException("O campo 'cidade' não pode ser nulo.");
        }

        SetorArea setor = new SetorArea();
        setor.setId(mariaDaPenha.getSetorArea().getId()); // Substitua SetorArea pelo nome da classe de setor
        mariaDaPenha.setSetorArea(setor);

        
        List<MeioEmpregado> meioEmpregadoList = meioEmpregadoService.buscarMeioEmpregadoPorIds(mariaDaPenha.getMeioEmpregadoIds());

        
        mariaDaPenha.setMeioEmpregado(meioEmpregadoList);

        Ocorrencia savedOcorrencia = ocorrenciasService.createOcorrencia(mariaDaPenha);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOcorrencia);
    }
}

