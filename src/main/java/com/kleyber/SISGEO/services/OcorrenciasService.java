package com.kleyber.SISGEO.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.MariaDaPenha;
import com.kleyber.SISGEO.dominio.MausTratos;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.repositorios.MariaDaPenhaReposiotrio;
import com.kleyber.SISGEO.repositorios.MausTratosRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OcorrenciasService {

    @Autowired
    private MariaDaPenhaReposiotrio mariaDaPenhaRepository;

    @Autowired
    private MausTratosRepository mausTratosRepository;

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
        
        // Lida com outros tipos de ocorrência aqui, se necessário

        return null; // Retorna null se a ocorrência não for encontrada
    }


    public Ocorrencia createOcorrencia(Ocorrencia ocorrencia) {
        if (ocorrencia instanceof MariaDaPenha) {
            return mariaDaPenhaRepository.save((MariaDaPenha) ocorrencia);
        } else if (ocorrencia instanceof MausTratos) {
            return mausTratosRepository.save((MausTratos) ocorrencia);
        }
        // Lida com outros tipos de ocorrência aqui, se necessário
        return null;
    }

    public List<Ocorrencia> listAllOcorrencias() {
        // Combine e retorne todas as ocorrências de todos os repositórios
        List<Ocorrencia> todasOcorrencias = new ArrayList<>();
        todasOcorrencias.addAll(mariaDaPenhaRepository.findAll());
        todasOcorrencias.addAll(mausTratosRepository.findAll());
        // Adicione outras listas, se houver
        return todasOcorrencias;
    }







    public void deleteOcorrencia(Integer id) {
        MariaDaPenha mariaDaPenha = mariaDaPenhaRepository.findById(id).orElse(null);
        MausTratos mausTratos = mausTratosRepository.findById(id).orElse(null);
        
        if (mariaDaPenha != null) {
            mariaDaPenhaRepository.deleteById(id);
        } else if (mausTratos != null) {
            mausTratosRepository.deleteById(id);
        }
        // Lida com outros tipos de ocorrência aqui, se necessário
    }

    }



