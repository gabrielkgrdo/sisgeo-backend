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
import com.kleyber.SISGEO.repositorios.PessoaRepositorio;

@Service
public class DBService {
	
	@Autowired
	private PessoaRepositorio pessoaRepositorio;
	@Autowired
	private OcorrenciasRepositorio ocorrenciasRepositorio;
	@Autowired
	private BCryptPasswordEncoder codificador;
	

	public void instanciaDB() {
		Servidor servidor1 = new Servidor(null, "Kleyber Gabriel", "394.040.010-66", "kleyber@mail.com", codificador.encode("123"));
		servidor1.addPerfil(Perfil.ADMIN);
		
		Servidor servidor2 = new Servidor(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", codificador.encode("123"));
		Servidor servidor3 = new Servidor(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", codificador.encode("123"));
		Servidor servidor4 = new Servidor(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", codificador.encode("123"));
		Servidor servidor5 = new Servidor(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", codificador.encode("123"));
		Servidor servidor6 = new Servidor(null, "Emily Cunha ", "916.265.220-65", "emily.com", codificador.encode("123"));
		
		
		Usuario usuario1 = new Usuario(null, "Biel Sales", "678.193.560-73", "biel@mail.com", codificador.encode("123"));
		Usuario usuario2 = new Usuario(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", codificador.encode("123"));
		Usuario usuario3 = new Usuario(null, "Marie Curie", "322.429.140-06", "curie@mail.com", codificador.encode("123"));
		Usuario usuario4 = new Usuario(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", codificador.encode("123"));
		Usuario usuario5 = new Usuario(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", codificador.encode("123"));
		Usuario usuario6 = new Usuario(null, "Max Planck", "081.399.300-83", "planck@mail.com", codificador.encode("123"));
		
		
		Ocorrencias ocorrencia1 = new Ocorrencias(null, Prioridade.MEDIA, Status.ANDAMENTO, "Ocorrencia 1", "Primeira ocorrencia",
				servidor1, usuario1);
		Ocorrencias ocorrencia2 = new Ocorrencias(null, Prioridade.ALTA, Status.ANDAMENTO, "Ocorrencia 2", "teste segunda ocorrencia",
				servidor2, usuario2);
		Ocorrencias ocorrencia3 = new Ocorrencias(null, Prioridade.BAIXA, Status.ANDAMENTO, "Ocorrencia 3", "teste terceira ocorrencia",
				servidor3, usuario3);
		Ocorrencias ocorrencia4 = new Ocorrencias(null, Prioridade.ALTA, Status.ANDAMENTO, "Ocorrencia 4", "teste quarta ocorrencia",
				servidor4, usuario4);
		Ocorrencias ocorrencia5 = new Ocorrencias(null, Prioridade.MEDIA, Status.ANDAMENTO, "Ocorrencia 5", "teste quinta ocorrencia",
				servidor5, usuario5);
		Ocorrencias ocorrencia6 = new Ocorrencias(null, Prioridade.BAIXA, Status.ANDAMENTO, "Ocorrencia 6", "teste sexta ocorrencia",
				servidor6, usuario6);
		
		pessoaRepositorio.saveAll(Arrays.asList(servidor1, servidor2, servidor3, servidor4, servidor5, servidor6, 
				usuario1, usuario2, usuario3, usuario4, usuario5, usuario6));
		ocorrenciasRepositorio.saveAll(Arrays.asList(ocorrencia1, ocorrencia2, ocorrencia3, ocorrencia4, ocorrencia5, ocorrencia6));
	}
}
