package com.kleyber.SISGEO.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kleyber.SISGEO.dominio.AcidenteTransito;
import com.kleyber.SISGEO.dominio.Ameaca;
import com.kleyber.SISGEO.dominio.DesaparecimentoPessoa;
import com.kleyber.SISGEO.dominio.Estelionato;
import com.kleyber.SISGEO.dominio.Furto;
import com.kleyber.SISGEO.dominio.LesaoCorporal;
import com.kleyber.SISGEO.dominio.MariaDaPenha;
import com.kleyber.SISGEO.dominio.MausTratos;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.OfensasRaciais;
import com.kleyber.SISGEO.dominio.Pertubacao;
import com.kleyber.SISGEO.dominio.Roubo;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.repositorios.AcidenteTransitoRepository;
import com.kleyber.SISGEO.repositorios.AmeacaRepository;
import com.kleyber.SISGEO.repositorios.DesaparecimentoRepository;
import com.kleyber.SISGEO.repositorios.EstelionatoRepository;
import com.kleyber.SISGEO.repositorios.FurtoRepository;
import com.kleyber.SISGEO.repositorios.LesaoCorporalRepository;
import com.kleyber.SISGEO.repositorios.MariaDaPenhaReposiotrio;
import com.kleyber.SISGEO.repositorios.MausTratosRepository;
import com.kleyber.SISGEO.repositorios.OfensasRaciaisRepository;
import com.kleyber.SISGEO.repositorios.PertubacaoRepository;
import com.kleyber.SISGEO.repositorios.RouboRepository;
import com.kleyber.SISGEO.services.OcorrenciasService;

@RestController
@RequestMapping("/ocorrencias")
public class OcorrenciaResource {

	@Autowired
	private OcorrenciasService ocorrenciasService;
	@Autowired
	private MariaDaPenhaReposiotrio mariaDaPenhaRepository;

	@Autowired
	private MausTratosRepository mausTratosRepository;
	
	@Autowired
	private AcidenteTransitoRepository acidenteTransitoRepository;
	
	@Autowired
    private FurtoRepository furtoRepository;
    
    @Autowired
    private RouboRepository rouboRepository;
    
    @Autowired
    private AmeacaRepository ameacaRepository;
    
    @Autowired
    private DesaparecimentoRepository desaparecimentoRepository;
    
    @Autowired
    private EstelionatoRepository estelionatoRepository;
    
    @Autowired
    private LesaoCorporalRepository lesaoCorporalRepository;
    
    @Autowired
    private OfensasRaciaisRepository ofensasRaciaisRepository;
    
    @Autowired
    private PertubacaoRepository pertubacaoRepository;

	@GetMapping
	public ResponseEntity<List<Ocorrencia>> listAllOcorrencias() {
		List<Ocorrencia> ocorrencias = ocorrenciasService.listAllOcorrencias();
		return new ResponseEntity<>(ocorrencias, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ocorrencia> getOcorrenciaById(@PathVariable Integer id) {
		Ocorrencia ocorrencia = ocorrenciasService.findById(id);
		if (ocorrencia != null) {
			return new ResponseEntity<>(ocorrencia, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Ocorrencia> createOcorrencia(@RequestBody Ocorrencia ocorrencia) {
		Ocorrencia createdOcorrencia = ocorrenciasService.createOcorrencia(ocorrencia);
		return new ResponseEntity<>(createdOcorrencia, HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
    public ResponseEntity<Ocorrencia> updateOcorrencia(@PathVariable Integer id, @RequestBody Ocorrencia ocorrencia) {
        Ocorrencia existingOcorrencia = ocorrenciasService.findById(id);

        if (existingOcorrencia != null) {
            // Você tem a ocorrência existente com o ID especificado.
        	 Servidor novoServidor = ocorrencia.getServidor();
             existingOcorrencia.setServidor(novoServidor);
            // Faça a atualização dos campos de prioridade e status, se eles não forem nulos.
            if (ocorrencia.getPrioridade() != null) {
                existingOcorrencia.setPrioridade(ocorrencia.getPrioridade());
            }
            if (ocorrencia.getStatus() != null) {
                existingOcorrencia.setStatus(ocorrencia.getStatus());
            }

            // Salve a ocorrência atualizada no repositório apropriado.
            if (existingOcorrencia instanceof MariaDaPenha) {
                mariaDaPenhaRepository.save((MariaDaPenha) existingOcorrencia);
            } else if (existingOcorrencia instanceof MausTratos) {
                mausTratosRepository.save((MausTratos) existingOcorrencia);
            }else if (existingOcorrencia instanceof AcidenteTransito) {
                acidenteTransitoRepository.save((AcidenteTransito) existingOcorrencia);
            }else if (existingOcorrencia instanceof Furto) {
                furtoRepository.save((Furto) existingOcorrencia);
            }else if (existingOcorrencia instanceof Roubo) {
                rouboRepository.save((Roubo) existingOcorrencia);
            }else if (existingOcorrencia instanceof Ameaca) {
                ameacaRepository.save((Ameaca) existingOcorrencia);
            }else if (existingOcorrencia instanceof DesaparecimentoPessoa) {
                desaparecimentoRepository.save((DesaparecimentoPessoa) existingOcorrencia);
            }else if (existingOcorrencia instanceof Estelionato) {
                estelionatoRepository.save((Estelionato) existingOcorrencia);
            }else if (existingOcorrencia instanceof LesaoCorporal) {
                lesaoCorporalRepository.save((LesaoCorporal) existingOcorrencia);
            }else if (existingOcorrencia instanceof OfensasRaciais) {
                ofensasRaciaisRepository.save((OfensasRaciais) existingOcorrencia);
            }else if (existingOcorrencia instanceof Pertubacao) {
                pertubacaoRepository.save((Pertubacao) existingOcorrencia);
            }
            

            return ResponseEntity.ok(existingOcorrencia);
        } else {
            // Se o ID não existe ou a ocorrência não foi encontrada, retorne ResponseEntity.notFound() ou lance uma exceção, dependendo da sua lógica.
            return ResponseEntity.notFound().build();
        }
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOcorrencia(@PathVariable Integer id) {
		ocorrenciasService.deleteOcorrencia(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
