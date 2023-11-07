package com.kleyber.SISGEO.dominio;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.kleyber.SISGEO.dominio.enumeradores.Prioridade;
import com.kleyber.SISGEO.dominio.enumeradores.Status;

@Entity
public class Ocorrencia {

	 	@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Integer id;
	 	
	 	@JsonFormat(pattern = "dd/MM/yyyy")
	 	private LocalDate dataAbertura = LocalDate.now();
	 	
	    private String dataInicio;
	    
	    private String horaInicio;
	    
	    private String dataFim;
	    
	    private String horaFim;
	    private String uf;
	    
	    
	    
	    @ManyToOne
	    @JoinColumn(name = "cidade_id")

	    private Cidade cidade;
	    
	    @ManyToOne
	    @JoinColumn(name = "setor_id")

	    private SetorArea setorArea;
	    private String quadra;
	    private String complemento;
	    
	    @Enumerated(EnumType.ORDINAL)
	    private Prioridade prioridade;
	    @Enumerated(EnumType.ORDINAL)
		private Status status;
	    
	    @ManyToOne
		@JoinColumn(name = "servidor_id")
	    
		private Servidor servidor;
	    
	    @ManyToOne
		@JoinColumn(name = "usuario_id")
	    
		private Usuario usuario;
	    
	    @ManyToOne
	    @JoinColumn(name = "tipo_local_criminal_id")

	    private TipoLocalCriminal tipoLocalCriminal;
	    
	    @Column(columnDefinition = "LONGTEXT")
	    private String descricao;
	    
	    @ElementCollection
	    private List<Long> meioEmpregadoIds;

	    @ManyToOne
	    @JoinColumn(name = "tipo_ocorrencia_id")
	    
	    private TipoOcorrencia tipoOcorrencia;
	    
	    

		public Ocorrencia() {
			super();
		}

		
		
		
		




		public Ocorrencia(Integer id, String dataInicio, Prioridade prioridade, Status status ,String horaInicio, String dataFim, String horaFim, String uf,
				Cidade cidade, SetorArea setorArea, String quadra, String complemento, Servidor servidor,
				Usuario usuario, TipoLocalCriminal tipoLocalCriminal, String descricao, List<Long> meioEmpregadoIds,
				TipoOcorrencia tipoOcorrencia) {
			super();
			this.id = id;
			this.dataInicio = dataInicio;
			this.horaInicio = horaInicio;
			this.dataFim = dataFim;
			this.horaFim = horaFim;
			this.uf = uf;
			this.cidade = cidade;
			this.setorArea = setorArea;
			this.quadra = quadra;
			this.complemento = complemento;
			this.prioridade = prioridade;
			this.status = status;
		
			this.servidor = servidor;
			this.usuario = usuario;
			this.tipoLocalCriminal = tipoLocalCriminal;
			this.descricao = descricao;
			this.meioEmpregadoIds = meioEmpregadoIds;
			this.tipoOcorrencia = tipoOcorrencia;
		}


		public Ocorrencia(Ocorrencia obj) {
		    this.id = obj.getId();
		    this.dataInicio = obj.getDataInicio();
		    this.horaInicio = obj.getHoraInicio();
		    this.dataFim = obj.getDataFim();
		    this.horaFim = obj.getHoraFim();
		    this.uf = obj.getUf();
		    this.cidade = obj.getCidade();
		    this.prioridade = obj.getPrioridade();
		    this.status = obj.getStatus();
		   
		    this.setorArea = obj.getSetorArea();
		    this.quadra = obj.getQuadra();
		    this.complemento = obj.getComplemento();
		    this.servidor = obj.getServidor();
		    this.usuario = obj.getUsuario();
		    this.tipoLocalCriminal = obj.getTipoLocalCriminal();
		    this.descricao = obj.getDescricao();
		    this.tipoOcorrencia = obj.getTipoOcorrencia();
		}



		



		public LocalDate getDataAbertura() {
			return dataAbertura;
		}









		public void setDataAbertura(LocalDate dataAbertura) {
			this.dataAbertura = dataAbertura;
		}









		public Prioridade getPrioridade() {
			return prioridade;
		}









		public void setPrioridade(Prioridade prioridade) {
			this.prioridade = prioridade;
		}









		public Status getStatus() {
			return status;
		}









		public void setStatus(Status status) {
			this.status = status;
		}









		public Servidor getServidor() {
			return servidor;
		}









		public void setServidor(Servidor servidor) {
			this.servidor = servidor;
		}









		public Usuario getUsuario() {
			return usuario;
		}









		public void setUsuario(Usuario usuario) {
			this.usuario = usuario;
		}









		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getDataInicio() {
			return dataInicio;
		}

		public void setDataInicio(String dataInicio) {
			this.dataInicio = dataInicio;
		}

		public String getHoraInicio() {
			return horaInicio;
		}

		public void setHoraInicio(String horaInicio) {
			this.horaInicio = horaInicio;
		}

		public String getDataFim() {
			return dataFim;
		}

		public void setDataFim(String dataFim) {
			this.dataFim = dataFim;
		}

		public String getHoraFim() {
			return horaFim;
		}

		public void setHoraFim(String horaFim) {
			this.horaFim = horaFim;
		}

		public String getUf() {
			return uf;
		}

		public void setUf(String uf) {
			this.uf = uf;
		}

		public Cidade getCidade() {
			return cidade;
		}

		public void setCidade(Cidade cidade) {
			this.cidade = cidade;
		}

		public SetorArea getSetorArea() {
			return setorArea;
		}

		public void setSetorArea(SetorArea setorArea) {
			this.setorArea = setorArea;
		}

		public String getQuadra() {
			return quadra;
		}

		public void setQuadra(String quadra) {
			this.quadra = quadra;
		}

		public String getComplemento() {
			return complemento;
		}

		public void setComplemento(String complemento) {
			this.complemento = complemento;
		}

		public TipoLocalCriminal getTipoLocalCriminal() {
			return tipoLocalCriminal;
		}

		public void setTipoLocalCriminal(TipoLocalCriminal tipoLocalCriminal) {
			this.tipoLocalCriminal = tipoLocalCriminal;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public List<Long> getMeioEmpregadoIds() {
			return meioEmpregadoIds;
		}

		public void setMeioEmpregadoIds(List<Long> meioEmpregadoIds) {
			this.meioEmpregadoIds = meioEmpregadoIds;
		}

		public TipoOcorrencia getTipoOcorrencia() {
			return tipoOcorrencia;
		}

		public void setTipoOcorrencia(TipoOcorrencia tipoOcorrencia) {
			this.tipoOcorrencia = tipoOcorrencia;
		}

	    
}
