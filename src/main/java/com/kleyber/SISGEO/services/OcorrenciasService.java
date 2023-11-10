package com.kleyber.SISGEO.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciasService {

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

    public Ocorrencia findById(Integer id) {
        // Verifique em qual repositório buscar com base no ID
        Optional<MariaDaPenha> mariaDaPenha = mariaDaPenhaRepository.findById(id);
        if (mariaDaPenha.isPresent()) {
            return mariaDaPenha.get();
        }
        
        Optional<MausTratos> mausTratos = mausTratosRepository.findById(id);
        if (mausTratos.isPresent()) {
            return mausTratos.get();
        }
        
        Optional<AcidenteTransito> acidenteTransito = acidenteTransitoRepository.findById(id);
        if (acidenteTransito.isPresent()) {
            return acidenteTransito.get();
        }
        
        Optional<Furto> furto = furtoRepository.findById(id);
        if (furto.isPresent()) {
            return furto.get();
        }
        
        Optional<Roubo> roubo = rouboRepository.findById(id);
        if (roubo.isPresent()) {
            return roubo.get();
        }
        
        Optional<Ameaca> ameaca = ameacaRepository.findById(id);
        if (ameaca.isPresent()) {
            return ameaca.get();
        }
        
        Optional<DesaparecimentoPessoa> desaparecimento = desaparecimentoRepository.findById(id);
        if (desaparecimento.isPresent()) {
            return desaparecimento.get();
        }
        
        Optional<Estelionato> estelionato = estelionatoRepository.findById(id);
        if (estelionato.isPresent()) {
            return estelionato.get();
        }
        
        Optional<LesaoCorporal> lesaoCorporal = lesaoCorporalRepository.findById(id);
        if (lesaoCorporal.isPresent()) {
            return lesaoCorporal.get();
        }
        
        Optional<OfensasRaciais> ofensas = ofensasRaciaisRepository.findById(id);
        if (ofensas.isPresent()) {
            return ofensas.get();
        }
        
        Optional<Pertubacao> pertubacao = pertubacaoRepository.findById(id);
        if (pertubacao.isPresent()) {
            return pertubacao.get();
        }
        
        // Lida com outros tipos de ocorrência aqui, se necessário

        return null; // Retorna null se a ocorrência não for encontrada
    }


    public Ocorrencia createOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia instanceof MariaDaPenha) {
            return mariaDaPenhaRepository.save((MariaDaPenha) ocorrencia);
        } else if (ocorrencia instanceof MausTratos) {
            return mausTratosRepository.save((MausTratos) ocorrencia);
        }else if (ocorrencia instanceof AcidenteTransito) {
            return acidenteTransitoRepository.save((AcidenteTransito) ocorrencia);
        }else if (ocorrencia instanceof Roubo) {
            return rouboRepository.save((Roubo) ocorrencia);
        }else if (ocorrencia instanceof Furto) {
            return furtoRepository.save((Furto) ocorrencia);
        }else if (ocorrencia instanceof Ameaca) {
            return ameacaRepository.save((Ameaca) ocorrencia);
        }else if (ocorrencia instanceof DesaparecimentoPessoa) {
            return desaparecimentoRepository.save((DesaparecimentoPessoa) ocorrencia);
        }else if (ocorrencia instanceof Estelionato) {
            return estelionatoRepository.save((Estelionato) ocorrencia);
        }else if (ocorrencia instanceof LesaoCorporal) {
            return lesaoCorporalRepository.save((LesaoCorporal) ocorrencia);
        }else if (ocorrencia instanceof OfensasRaciais) {
            return ofensasRaciaisRepository.save((OfensasRaciais) ocorrencia);
        }else if (ocorrencia instanceof Pertubacao) {
            return pertubacaoRepository.save((Pertubacao) ocorrencia);
        }                         
        
        return null;
    }

    public List<Ocorrencia> listAllOcorrencias() {
        // Combine e retorne todas as ocorrências de todos os repositórios
        List<Ocorrencia> todasOcorrencias = new ArrayList<>();
        todasOcorrencias.addAll(mariaDaPenhaRepository.findAll());
        todasOcorrencias.addAll(mausTratosRepository.findAll());
        todasOcorrencias.addAll(acidenteTransitoRepository.findAll());
        todasOcorrencias.addAll(furtoRepository.findAll());
        todasOcorrencias.addAll(rouboRepository.findAll());
        todasOcorrencias.addAll(ameacaRepository.findAll());
        todasOcorrencias.addAll(desaparecimentoRepository.findAll());
        todasOcorrencias.addAll(estelionatoRepository.findAll());
        todasOcorrencias.addAll(lesaoCorporalRepository.findAll());
        todasOcorrencias.addAll(ofensasRaciaisRepository.findAll());
        todasOcorrencias.addAll(pertubacaoRepository.findAll());
        // Adicione outras listas, se houver
        return todasOcorrencias;
    }

    public void deleteOcorrencia(Integer id) {
        MariaDaPenha mariaDaPenha = mariaDaPenhaRepository.findById(id).orElse(null);
        MausTratos mausTratos = mausTratosRepository.findById(id).orElse(null);
        AcidenteTransito acidenteTransito = acidenteTransitoRepository.findById(id).orElse(null);
        
        if (mariaDaPenha != null) {
            mariaDaPenhaRepository.deleteById(id);
        } else if (mausTratos != null) {
            mausTratosRepository.deleteById(id);
        }
        else if (acidenteTransito != null) {
        	acidenteTransitoRepository.deleteById(id);
        }
        // Lida com outros tipos de ocorrência aqui, se necessário
    }

    }



