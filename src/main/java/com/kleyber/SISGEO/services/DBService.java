package com.kleyber.SISGEO.services;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.kleyber.SISGEO.dominio.Cidade;
import com.kleyber.SISGEO.dominio.MeioEmpregado;
import com.kleyber.SISGEO.dominio.Ocorrencia;
import com.kleyber.SISGEO.dominio.Servidor;
import com.kleyber.SISGEO.dominio.SetorArea;
import com.kleyber.SISGEO.dominio.TipoLocalCriminal;
import com.kleyber.SISGEO.dominio.TipoOcorrencia;
import com.kleyber.SISGEO.dominio.Usuario;
import com.kleyber.SISGEO.dominio.enumeradores.Perfil;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;
import com.kleyber.SISGEO.repositorios.CidadeRepositorio;
import com.kleyber.SISGEO.repositorios.MeioEmpregadoRepository;
import com.kleyber.SISGEO.repositorios.OcorrenciaRepository;
import com.kleyber.SISGEO.repositorios.ServidorRepositorio;
import com.kleyber.SISGEO.repositorios.SetorAreaRepositorio;
import com.kleyber.SISGEO.repositorios.TipoLocalCriminalRepository;
import com.kleyber.SISGEO.repositorios.TipoOcorrenciaRepository;
import com.kleyber.SISGEO.repositorios.UsuarioRepositorio;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private ServidorRepositorio servidorRepositorio;
	@Autowired
	private OcorrenciaRepository ocorrenciasRepositorio;
	@Autowired
	private CidadeRepositorio cidadeRepositorio;
	@Autowired
	private SetorAreaRepositorio setorAreaRepositorio;
	@Autowired
	private TipoOcorrenciaRepository tipoOcorrenciaRepository;
	@Autowired
	private TipoLocalCriminalRepository tipoLocalCriminalRepository;
	@Autowired
	private MeioEmpregadoRepository meioEmpregadoRepository;
	@Autowired
	private BCryptPasswordEncoder codificador;
	

	public void instanciaDB() {
		Servidor servidor1 = new Servidor(null, "Kleyber Gabriel", "394.040.010-66", "kleyber@mail.com", codificador.encode("123"));
		servidor1.addPerfil(Perfil.ADMIN);
		
		Servidor servidor2 = new Servidor(null, "Richard Stallman", "903.347.070-56", "stallman@mail.com", codificador.encode("123"));
		Servidor servidor3 = new Servidor(null, "Claude Elwood Shannon", "271.068.470-54", "shannon@mail.com", codificador.encode("123"));
		Servidor servidor4 = new Servidor(null, "Tim Berners-Lee", "162.720.120-39", "lee@mail.com", codificador.encode("123"));
		Servidor servidor5 = new Servidor(null, "Linus Torvalds", "778.556.170-27", "linus@mail.com", codificador.encode("123"));
	
		
		
		Usuario usuario1 = new Usuario(null, "Biel Sales", "678.193.560-73", "biel@mail.com", codificador.encode("123"));
		Usuario usuario2 = new Usuario(null, "Albert Einstein", "111.661.890-74", "einstein@mail.com", codificador.encode("123"));
		Usuario usuario3 = new Usuario(null, "Marie Curie", "322.429.140-06", "curie@mail.com", codificador.encode("123"));
		Usuario usuario4 = new Usuario(null, "Charles Darwin", "792.043.830-62", "darwin@mail.com", codificador.encode("123"));
		Usuario usuario5 = new Usuario(null, "Stephen Hawking", "177.409.680-30", "hawking@mail.com", codificador.encode("123"));

		
		
		
		
		TipoOcorrencia mariaDaPenha = new TipoOcorrencia(null, "Maria da Penha");
	    TipoOcorrencia mausTratosAnimais = new TipoOcorrencia(null, "Maus Tratos aos Animais");
	    TipoOcorrencia acidenteTransito = new TipoOcorrencia(null, "Acidente de Trânsito");
	    TipoOcorrencia furto = new TipoOcorrencia(null, "Furto");
	    TipoOcorrencia roubo = new TipoOcorrencia(null, "Roubo");
	    TipoOcorrencia ameacaOcorrencia = new TipoOcorrencia(null, "Ameaça");
	    TipoOcorrencia desaparecimentoPessoa = new TipoOcorrencia(null, "Desaparecimento de pessoa");
	    TipoOcorrencia estelionato = new TipoOcorrencia(null, "Estelionato, fraudes ou apropiações");
	    TipoOcorrencia lesaoCorporal = new TipoOcorrencia(null, "Lesão Corporal");
	    TipoOcorrencia ofensasRaciais = new TipoOcorrencia(null, "Ofensas Raciais");
	    TipoOcorrencia pertubacao = new TipoOcorrencia(null, "Pertubação");
	    
	    tipoOcorrenciaRepository.saveAll(Arrays.asList(mariaDaPenha,mausTratosAnimais,acidenteTransito,furto,roubo,ameacaOcorrencia,desaparecimentoPessoa,estelionato,
	    		lesaoCorporal,ofensasRaciais,pertubacao));
	    
	    
	    
	    TipoLocalCriminal agenciaBancaria = new TipoLocalCriminal(null, "AGÊNCIA BANCÁRIA");
	    TipoLocalCriminal comercio = new TipoLocalCriminal(null, "COMÉRCIO DIVERSOS");
	    TipoLocalCriminal entrequadra = new TipoLocalCriminal(null, "ENTREQUADRA");
	    TipoLocalCriminal escola = new TipoLocalCriminal(null, "ESCOLA IMEDIAÇÕES");
	    TipoLocalCriminal estabelecimentoDiversao = new TipoLocalCriminal(null, "ESTABELECIMENTO DIVERSÃO");
	    TipoLocalCriminal estacionamento = new TipoLocalCriminal(null, "ESTACIONAMENTO");
	    TipoLocalCriminal estadio = new TipoLocalCriminal(null, "ESTÁDIO IMEDIAÇÕES");
	    TipoLocalCriminal instituicaoFinanceira = new TipoLocalCriminal(null, "INSTITUIÇÃO FINANCEIRA");
	    TipoLocalCriminal interiorVeiculo = new TipoLocalCriminal(null, "INTERIOR DE VEÍCULOS");
	    TipoLocalCriminal naoInformado = new TipoLocalCriminal(null, "NÃO INFORMADO");
	    TipoLocalCriminal orgaoPublico = new TipoLocalCriminal(null, "ORGÃO PÚBLICO");
	    TipoLocalCriminal outros = new TipoLocalCriminal(null, "OUTROS");
	    TipoLocalCriminal pontoOnibus = new TipoLocalCriminal(null, "PONTO DE ÔNIBUS");
	    TipoLocalCriminal residencia = new TipoLocalCriminal(null, "RESIDÊNCIA");
	    TipoLocalCriminal cartaMensagem = new TipoLocalCriminal(null, "VIA CARTA/MENSAGEM ELETRÔNICA");
	    TipoLocalCriminal internet = new TipoLocalCriminal(null, "VIA INTERNET");
	    TipoLocalCriminal ligacaoTelefonica = new TipoLocalCriminal(null, "VIA LIGAÇÃO TELEFÔNICA");
	    TipoLocalCriminal viaPublica = new TipoLocalCriminal(null, "VIA PÚBLICA");
	    TipoLocalCriminal zonaRural = new TipoLocalCriminal(null, "ZONA RURAL");
	    
	    tipoLocalCriminalRepository.saveAll(Arrays.asList(agenciaBancaria,comercio,entrequadra,escola,estabelecimentoDiversao,
	    		estacionamento,estadio,instituicaoFinanceira,interiorVeiculo,naoInformado,orgaoPublico,outros,pontoOnibus,residencia,cartaMensagem,
	    		internet,ligacaoTelefonica,viaPublica,zonaRural));
	    
	    
	    MeioEmpregado agressaoMoral = new MeioEmpregado(null, "AGRESSÃO MORAL");
	    MeioEmpregado ameaca = new MeioEmpregado(null, "AMEAÇA");
	    MeioEmpregado apropriacao = new MeioEmpregado(null, "APROPRIAÇÃO");
	    MeioEmpregado armaCortePerfuracao = new MeioEmpregado(null, "ARMA DE CORTE / PERFURACÃO");
	    MeioEmpregado armaDeFogo = new MeioEmpregado(null, "ARMA DE FOGO");
	    MeioEmpregado arrombamento = new MeioEmpregado(null, "ARROMBAMENTO");
	    MeioEmpregado explosivo = new MeioEmpregado(null, "ARTEFATO EXPLOSIVO");
	    MeioEmpregado clonagemDados = new MeioEmpregado(null, "CLONAGEM DE DADOS");
	    MeioEmpregado clonagemPagina = new MeioEmpregado(null, "CLONAGEM DE PÁGINA");
	    MeioEmpregado corrente = new MeioEmpregado(null, "CORRENTE");
	    MeioEmpregado documentosFalsos = new MeioEmpregado(null, "DOCUMENTOS FALSOS");
	    MeioEmpregado fio = new MeioEmpregado(null, "FIO");
	    MeioEmpregado fraude = new MeioEmpregado(null, "FRAUDE");
	    MeioEmpregado outros2 = new MeioEmpregado(null, "OUTROS");
	    MeioEmpregado madeiraFerro = new MeioEmpregado(null, "SEGMENTO DE MADEIRA/FERRO");
	    MeioEmpregado violenciaFisica = new MeioEmpregado(null, "VIOLÊNCIA FÍSICA");
	    MeioEmpregado violenciaSexual = new MeioEmpregado(null, "VIOLÊNCIA SEXUAL");
	    
	    
	    meioEmpregadoRepository.saveAll(Arrays.asList(agressaoMoral,ameaca,apropriacao,armaCortePerfuracao,armaDeFogo,arrombamento,explosivo,
	    		clonagemDados,clonagemPagina,corrente,documentosFalsos,fio,fraude,outros2,madeiraFerro,violenciaFisica,violenciaSexual	));
		

		
		Cidade cidadeAguasClaras = new Cidade(null, "ÁGUAS CLARAS", new HashSet<>());
		Cidade cidadeArniqueiras = new Cidade(null, "ARNIQUEIRA", new HashSet<>());
		Cidade cidadeBrasilia = new Cidade(null, "BRASÍLIA", new HashSet<>());
		Cidade cidadeBrazlandia = new Cidade(null, "BRAZLÂNDIA", new HashSet<>());
		Cidade cidadeCandangolandia = new Cidade(null, "CANDANGOLÂNDIA", new HashSet<>());
	    Cidade cidadeCeilandia = new Cidade(null, "CEILÂNDIA", new HashSet<>());
	    Cidade cidadeCruzeiro = new Cidade(null, "CRUZEIRO", new HashSet<>());
	    Cidade cidadeEstrutural = new Cidade(null, "ESTRUTURAL", new HashSet<>());
	    Cidade cidadeFercal = new Cidade(null, "FERCAL", new HashSet<>());
	    Cidade cidadeGama = new Cidade(null, "GAMA", new HashSet<>());
	    Cidade cidadeGuara = new Cidade(null, "GUARÁ", new HashSet<>());
	    Cidade cidadeItapoa = new Cidade(null, "ITAPOÃ", new HashSet<>());
	    Cidade cidadeJardimBotanico = new Cidade(null, "JARDIM BOTÂNICO", new HashSet<>());
	    Cidade cidadeLagoNorte = new Cidade(null, "LAGO NORTE", new HashSet<>());
	    Cidade cidadeLagoSul = new Cidade(null, "LAGO SUL", new HashSet<>());
	    Cidade cidadeNucleoBandeirante = new Cidade(null, "NÚCLEO BANDEIRANTE", new HashSet<>());
	    Cidade cidadeOctogonal = new Cidade(null, "OCTOGONAL", new HashSet<>());
	    Cidade cidadeParanoa = new Cidade(null, "PARANOÁ", new HashSet<>());
	    Cidade cidadeParkWay= new Cidade(null, "PARK WAY", new HashSet<>());
	    Cidade cidadePlanaltina = new Cidade(null, "PLANALTINA", new HashSet<>());
	    Cidade cidadeRecanto = new Cidade(null, "RECANTO DAS EMAS", new HashSet<>());
	    Cidade cidadeRiacho = new Cidade(null, "RIACHO FUNDO", new HashSet<>());
	    Cidade cidadeRiacho2 = new Cidade(null, "RIACHO FUNDO II", new HashSet<>());
	    Cidade cidadeSamamba = new Cidade(null, "SAMAMBAIA", new HashSet<>());
	    Cidade cidadeSantaMaria = new Cidade(null, "SANTA MARIA", new HashSet<>());
	    Cidade cidadeSaoSebastiao = new Cidade(null, "SÃO SEBASTIÃO", new HashSet<>());
	    Cidade cidadeSia = new Cidade(null, "SIA", new HashSet<>());
	    Cidade cidadeSobradinho = new Cidade(null, "SOBRADINHO", new HashSet<>());
	    Cidade cidadeSobradinho2 = new Cidade(null, "SOBRADINHO II", new HashSet<>());
	    Cidade cidadeSolNascente = new Cidade(null, "SOL NASCENTE/POR DO SOL", new HashSet<>());
	    Cidade cidadeSudoeste = new Cidade(null, "SUDOESTE", new HashSet<>());
	    Cidade cidadeTaguatinga = new Cidade(null, "TAGUATINGA", new HashSet<>());
	    Cidade cidadeVarjao = new Cidade(null, "VARJÃO", new HashSet<>());
	    Cidade cidadeVicentePires = new Cidade(null, "VICENTE PIRES", new HashSet<>());
	    
	    cidadeRepositorio.saveAll(Arrays.asList(cidadeBrasilia, cidadeCeilandia,cidadeAguasClaras,cidadeArniqueiras,cidadeBrazlandia,
	    		cidadeCandangolandia,cidadeCruzeiro,cidadeEstrutural,cidadeFercal,cidadeGama,cidadeGuara,cidadeItapoa,cidadeJardimBotanico,
	    		cidadeLagoNorte,cidadeLagoSul,cidadeNucleoBandeirante,cidadeOctogonal,cidadeParanoa,cidadeParkWay,cidadePlanaltina,
	    		cidadeRecanto,cidadeRiacho,cidadeRiacho2,cidadeSamamba,cidadeSantaMaria,cidadeSaoSebastiao,cidadeSia,cidadeSobradinho,
	    		cidadeSobradinho2,cidadeSolNascente,cidadeSudoeste,cidadeTaguatinga,cidadeVarjao,cidadeVicentePires));

	    // SETORES AGUAS CLARAS
	    
	    SetorArea setorAguasClaras1 = new SetorArea(null, "ADE - AREA DE DESENVOLVIMENTO ECONOMICO", cidadeAguasClaras);
	    SetorArea setorAguasClaras2 = new SetorArea(null, "ADE AGUAS CLARAS ", cidadeAguasClaras);
	    SetorArea setorAguasClaras3 = new SetorArea(null, "Águas Claras Colônia Agrícola Governador", cidadeAguasClaras);
	    SetorArea setorAguasClaras4 = new SetorArea(null, "AVENIDA DAS ARAUCARIAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras5 = new SetorArea(null, "AVENIDA DAS CASTANHEIRAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras6 = new SetorArea(null, "AVENIDA JEQUITIBA", cidadeAguasClaras);
	    SetorArea setorAguasClaras7 = new SetorArea(null, "AVENIDA PARQUE AGUAS CLARAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras8 = new SetorArea(null, "AVENIDA PAU BRASIL", cidadeAguasClaras);
	    SetorArea setorAguasClaras9 = new SetorArea(null, "AVENIDA SIBIPIRUNA", cidadeAguasClaras);
	    SetorArea setorAguasClaras10 = new SetorArea(null, "BOULEVARD AGUAS CLARAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras11 = new SetorArea(null, "CHAC S/N", cidadeAguasClaras);
	    SetorArea setorAguasClaras12 = new SetorArea(null, "EPTG", cidadeAguasClaras);
	    SetorArea setorAguasClaras13 = new SetorArea(null, "Pátio da 21ª DP", cidadeAguasClaras);
	    SetorArea setorAguasClaras14 = new SetorArea(null, "PRACA DAS GARCAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras15 = new SetorArea(null, "Q 101 PRACA TIE", cidadeAguasClaras);
	    SetorArea setorAguasClaras16 = new SetorArea(null, "Q 102 PRACA PERDIZ ", cidadeAguasClaras);
	    SetorArea setorAguasClaras17 = new SetorArea(null, "Q 103 PRACA JURITI", cidadeAguasClaras);
	    SetorArea setorAguasClaras18 = new SetorArea(null, "Q 104 PRACA TIZIU ", cidadeAguasClaras);
	    SetorArea setorAguasClaras19 = new SetorArea(null, "Q 105 PRACA BEM TE VI", cidadeAguasClaras);
	    SetorArea setorAguasClaras20 = new SetorArea(null, "Q 106 PRACA CANARIO ", cidadeAguasClaras);
	    SetorArea setorAguasClaras21 = new SetorArea(null, "Q 107", cidadeAguasClaras);
	    SetorArea setorAguasClaras22 = new SetorArea(null, "Q 201", cidadeAguasClaras);
	    SetorArea setorAguasClaras23 = new SetorArea(null, "Q 202 PRACA IRERE", cidadeAguasClaras);
	    SetorArea setorAguasClaras24 = new SetorArea(null, "Q 203 PRACA ANDORINHA", cidadeAguasClaras);
	    SetorArea setorAguasClaras25 = new SetorArea(null, "Q 204 PRACA PARDAL", cidadeAguasClaras);
	    SetorArea setorAguasClaras26 = new SetorArea(null, "Q 205 PRACA JANDAIA", cidadeAguasClaras);
	    SetorArea setorAguasClaras27 = new SetorArea(null, "Q 206 PRACA TUIM", cidadeAguasClaras);
	    SetorArea setorAguasClaras28 = new SetorArea(null, "Q 207 PRACA UIRAPURU", cidadeAguasClaras);
	    SetorArea setorAguasClaras29 = new SetorArea(null, "Q 208 PRACA SABIA", cidadeAguasClaras);
	    SetorArea setorAguasClaras30 = new SetorArea(null, "Q 209 PRACA GRAUNA", cidadeAguasClaras);
	    SetorArea setorAguasClaras31 = new SetorArea(null, "Q 210 PRACA MARTIM PESCADOR", cidadeAguasClaras);
	    SetorArea setorAguasClaras32 = new SetorArea(null, "Q 301", cidadeAguasClaras);
	    SetorArea setorAguasClaras33 = new SetorArea(null, "QS 10", cidadeAguasClaras);
	    SetorArea setorAguasClaras34 = new SetorArea(null, "QS 11", cidadeAguasClaras);
	    SetorArea setorAguasClaras35 = new SetorArea(null, "QS 6", cidadeAguasClaras);
	    SetorArea setorAguasClaras36 = new SetorArea(null, "QS 7", cidadeAguasClaras);
	    SetorArea setorAguasClaras37 = new SetorArea(null, "QS 8", cidadeAguasClaras);
	    SetorArea setorAguasClaras38 = new SetorArea(null, "QS 9", cidadeAguasClaras);
	    SetorArea setorAguasClaras39 = new SetorArea(null, "RUA 12 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras40 = new SetorArea(null, "RUA 12 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras41 = new SetorArea(null, "RUA 13 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras42 = new SetorArea(null, "RUA 13 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras43 = new SetorArea(null, "RUA 14 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras44 = new SetorArea(null, "RUA 14 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras45 = new SetorArea(null, "RUA 16 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras46 = new SetorArea(null, "RUA 16 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras47 = new SetorArea(null, "RUA 17 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras48 = new SetorArea(null, "RUA 17 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras49 = new SetorArea(null, "RUA 18 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras50 = new SetorArea(null, "RUA 18 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras51 = new SetorArea(null, "RUA 19 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras52 = new SetorArea(null, "RUA 19 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras53 = new SetorArea(null, "RUA 20 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras54 = new SetorArea(null, "RUA 20 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras55 = new SetorArea(null, "RUA 21 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras56 = new SetorArea(null, "RUA 21 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras57 = new SetorArea(null, "RUA 22 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras58 = new SetorArea(null, "RUA 22 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras59 = new SetorArea(null, "RUA 24 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras60 = new SetorArea(null, "RUA 24 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras61 = new SetorArea(null, "RUA 25 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras62 = new SetorArea(null, "RUA 25 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras63 = new SetorArea(null, "RUA 26 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras64 = new SetorArea(null, "RUA 27 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras65 = new SetorArea(null, "RUA 28 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras66 = new SetorArea(null, "RUA 28 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras67 = new SetorArea(null, "RUA 3 E 4 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras68 = new SetorArea(null, "RUA 3 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras69 = new SetorArea(null, "RUA 3 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras70 = new SetorArea(null, "RUA 30 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras71 = new SetorArea(null, "RUA 30 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras72 = new SetorArea(null, "RUA 31 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras73 = new SetorArea(null, "RUA 31 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras74 = new SetorArea(null, "RUA 33 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras75 = new SetorArea(null, "RUA 33 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras76 = new SetorArea(null, "RUA 34 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras77 = new SetorArea(null, "RUA 34 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras78 = new SetorArea(null, "RUA 35 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras79 = new SetorArea(null, "RUA 35 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras80 = new SetorArea(null, "RUA 36 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras81 = new SetorArea(null, "RUA 36 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras82 = new SetorArea(null, "RUA 37 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras83 = new SetorArea(null, "RUA 37 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras84 = new SetorArea(null, "RUA 4 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras85 = new SetorArea(null, "RUA 4 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras86 = new SetorArea(null, "RUA 5 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras87 = new SetorArea(null, "RUA 5 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras88 = new SetorArea(null, "RUA 7 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras89 = new SetorArea(null, "RUA 7 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras90 = new SetorArea(null, "RUA 8 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras91 = new SetorArea(null, "RUA 8 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras92 = new SetorArea(null, "RUA 9 NORTE", cidadeAguasClaras);
	    SetorArea setorAguasClaras93 = new SetorArea(null, "RUA 9 SUL", cidadeAguasClaras);
	    SetorArea setorAguasClaras94 = new SetorArea(null, "RUA ACAI", cidadeAguasClaras);
	    SetorArea setorAguasClaras95 = new SetorArea(null, "RUA ALECRIM", cidadeAguasClaras);
	    SetorArea setorAguasClaras96 = new SetorArea(null, "RUA ARACA", cidadeAguasClaras);
	    SetorArea setorAguasClaras97 = new SetorArea(null, "RUA ARARIBA", cidadeAguasClaras);
	    SetorArea setorAguasClaras98 = new SetorArea(null, "RUA BABACU", cidadeAguasClaras);
	    SetorArea setorAguasClaras100 = new SetorArea(null, "RUA BURITI", cidadeAguasClaras);
	    SetorArea setorAguasClaras101 = new SetorArea(null, "RUA CANAÚBAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras102 = new SetorArea(null, "RUA COPAIBA", cidadeAguasClaras);
	    SetorArea setorAguasClaras103 = new SetorArea(null, "RUA DAS AROEIRAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras104 = new SetorArea(null, "RUA DAS CARNAUBAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras105 = new SetorArea(null, "RUA DAS FIGUEIRAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras106 = new SetorArea(null, "RUA DAS PAINEIRAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras107 = new SetorArea(null, "RUA DAS PITANGUEIRAS", cidadeAguasClaras);
	    SetorArea setorAguasClaras108 = new SetorArea(null, "RUA IPE AMARELO", cidadeAguasClaras);
	    SetorArea setorAguasClaras109 = new SetorArea(null, "RUA JACARANDA", cidadeAguasClaras);
	    SetorArea setorAguasClaras110 = new SetorArea(null, "RUA JERIVA", cidadeAguasClaras);
	    SetorArea setorAguasClaras111 = new SetorArea(null, "RUA MACAUBA", cidadeAguasClaras);
	    SetorArea setorAguasClaras112 = new SetorArea(null, "RUA MANACA", cidadeAguasClaras);
	    SetorArea setorAguasClaras113 = new SetorArea(null, "RUA TAMBORIL", cidadeAguasClaras);
	    SetorArea setorAguasClaras114 = new SetorArea(null, "RUA SH VICENTE PIRES / COLONIA AGRICOLA VICENTE PIRES", cidadeAguasClaras);
	    SetorArea setorAguasClaras115 = new SetorArea(null, "ZONA RURAL", cidadeAguasClaras);
	    
	    
        // SETORES BRASÍLIA	    	    	 
	    SetorArea setorBrasilia1 = new SetorArea(null, "Setor 1 - Brasília", cidadeBrasilia);
	    SetorArea setorBrasilia2 = new SetorArea(null, "Setor 2 - Brasília", cidadeBrasilia);
	    SetorArea setorCeilandia1 = new SetorArea(null, "Setor 1 - Ceilândia", cidadeCeilandia);
	    setorAreaRepositorio.saveAll(Arrays.asList(setorBrasilia1, setorBrasilia2, setorCeilandia1,setorAguasClaras1,setorAguasClaras2,
	    		setorAguasClaras3,setorAguasClaras4,setorAguasClaras5,setorAguasClaras6,setorAguasClaras7,setorAguasClaras8,setorAguasClaras9,
	    		setorAguasClaras10,setorAguasClaras11,setorAguasClaras12,setorAguasClaras13,setorAguasClaras14,setorAguasClaras15,setorAguasClaras16,setorAguasClaras17,setorAguasClaras18,setorAguasClaras19,setorAguasClaras20,setorAguasClaras21,setorAguasClaras22,setorAguasClaras23,setorAguasClaras24,setorAguasClaras25,setorAguasClaras26,setorAguasClaras27,setorAguasClaras28,setorAguasClaras29,setorAguasClaras30,
	    		setorAguasClaras31,setorAguasClaras32,setorAguasClaras33,setorAguasClaras34,setorAguasClaras35,setorAguasClaras36,setorAguasClaras37,setorAguasClaras38,setorAguasClaras39,setorAguasClaras40,setorAguasClaras41,setorAguasClaras42,setorAguasClaras43,setorAguasClaras44,setorAguasClaras45,setorAguasClaras46,setorAguasClaras47,setorAguasClaras48,setorAguasClaras49,setorAguasClaras50,setorAguasClaras51,setorAguasClaras52,
	    		setorAguasClaras53,setorAguasClaras54,setorAguasClaras55,setorAguasClaras56,setorAguasClaras57,setorAguasClaras58,setorAguasClaras59,setorAguasClaras60,setorAguasClaras61,setorAguasClaras62,setorAguasClaras63,setorAguasClaras64,setorAguasClaras65,setorAguasClaras66,setorAguasClaras67,setorAguasClaras68,setorAguasClaras69,setorAguasClaras70,setorAguasClaras71,setorAguasClaras72,setorAguasClaras73,setorAguasClaras74,setorAguasClaras75,
	    		setorAguasClaras76,setorAguasClaras77,setorAguasClaras78,setorAguasClaras79,setorAguasClaras80,setorAguasClaras81,setorAguasClaras82,setorAguasClaras83,setorAguasClaras84,setorAguasClaras85,setorAguasClaras86,setorAguasClaras87,setorAguasClaras88,setorAguasClaras89,setorAguasClaras90,setorAguasClaras91,setorAguasClaras92,setorAguasClaras93,setorAguasClaras94,setorAguasClaras95,setorAguasClaras96,setorAguasClaras97,setorAguasClaras98,
	    		setorAguasClaras98,setorAguasClaras100,setorAguasClaras101,setorAguasClaras102,setorAguasClaras103,setorAguasClaras104,setorAguasClaras105,setorAguasClaras106,setorAguasClaras107,setorAguasClaras108,setorAguasClaras109,setorAguasClaras110,setorAguasClaras111,setorAguasClaras112,setorAguasClaras113,setorAguasClaras114,setorAguasClaras115));
	    
	    
	    Ocorrencia ocorrencia1 = new Ocorrencia(null, "20/10/2023", Prioridade.MEDIA, Status.ABERTO, "9:30", "21/10/2023", "20:30", "DF", cidadeAguasClaras, setorAguasClaras115, "QUADRA 15", "15", servidor5, usuario5, zonaRural, "TESTE", null, mausTratosAnimais);
		Ocorrencia ocorrencia2 = new Ocorrencia(null, "20/10/2023", Prioridade.MEDIA, Status.ABERTO,"9:30", "21/10/2023", "20:30", "DF", cidadeAguasClaras, setorAguasClaras115, "QUADRA 15", "15", servidor5, usuario5, zonaRural, "TESTE", null, mausTratosAnimais);
		Ocorrencia ocorrencia3 = new Ocorrencia(null, "20/10/2023", Prioridade.MEDIA, Status.ABERTO,"9:30", "21/10/2023", "20:30", "DF", cidadeAguasClaras, setorAguasClaras115, "QUADRA 15", "15", servidor5, usuario5, zonaRural, "TESTE", null, mariaDaPenha);
		Ocorrencia ocorrencia4 = new Ocorrencia(null, "20/10/2023", Prioridade.MEDIA, Status.ABERTO,"9:30", "21/10/2023", "20:30", "DF", cidadeAguasClaras, setorAguasClaras115, "QUADRA 15", "15", servidor5, usuario5, zonaRural, "TESTE", null, mariaDaPenha);
		Ocorrencia ocorrencia5 = new Ocorrencia(null, "20/10/2023", Prioridade.MEDIA, Status.ABERTO,"9:30", "21/10/2023", "20:30", "DF", cidadeAguasClaras, setorAguasClaras115, "QUADRA 15", "15", servidor5, usuario5, zonaRural, "TESTE", null, mausTratosAnimais);
		
	
		servidorRepositorio.saveAll(Arrays.asList(servidor1, servidor2, servidor3, servidor4, servidor5));
		usuarioRepositorio.saveAll(Arrays.asList(usuario1, usuario2, usuario3, usuario4, usuario5));
		ocorrenciasRepositorio.saveAll(Arrays.asList(ocorrencia1, ocorrencia2, ocorrencia3, ocorrencia4, ocorrencia5));
	}
}
