package com.kleyber.SISGEO.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Ocorrencias;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.repositorios.OcorrenciasRepositorio;
import com.kleyber.SISGEO.repositorios.ServidorRepositorio;
import com.kleyber.SISGEO.repositorios.UsuarioRepositorio;

@Service
public class DBService {
	
	@Autowired
	private ServidorRepositorio servidorRepositorio;
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private OcorrenciasRepositorio ocorrenciasRepositorio;
	@Autowired
	private BCryptPasswordEncoder codificador;
	

	public void instanciaDB() {
		Servidor servidor1 = new Servidor(null, "Kleyber Gabriel", "394.040.010-66", "kleyber@mail.com", codificador.encode("123"));
		servidor1.addPerfil(Perfil.ADMIN);
		
		Usuario usuario1 = new Usuario(null, "Biel Sales", "678.193.560-73", "biel@mail.com", codificador.encode("123"));
		
		Ocorrencias ocorrencia1 = new Ocorrencias(null, Prioridade.MEDIA, Status.ANDAMENTO, "Ocorrencia 1", "Primeira ocorrencia", servidor1, usuario1);
		
		servidorRepositorio.saveAll(Arrays.asList(servidor1));
		usuarioRepositorio.saveAll(Arrays.asList(usuario1));
		ocorrenciasRepositorio.saveAll(Arrays.asList(ocorrencia1));
	}
}
