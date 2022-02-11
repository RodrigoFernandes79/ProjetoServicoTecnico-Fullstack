package com.servicoTecnico.os.dtos;

import java.time.LocalDateTime;

import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.servicoTecnico.os.models.Cliente;
import com.servicoTecnico.os.models.OrdemServico;
import com.servicoTecnico.os.models.Tecnico;

public class OrdemServicoDTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAbertura;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataFechamento;
	
	private Integer prioridade;
	@NotBlank(message ="O CAMPO OBSERVAÇÕES É REQUERIDO!")
	private String observacoes;
	
	private Integer status;
	
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	@NotNull(message="O CAMPO CLIENTE É REQUERIDO")
	private Long cliente;
	
	@ManyToOne
	@JoinColumn(name="tecnico_id")
	@NotNull(message="O CAMPO TÉCNICO É REQUERIDO")
	private Long tecnico;

	public OrdemServicoDTO() {
		super();
	
	}

	public OrdemServicoDTO(OrdemServico os) {
		super();
		this.id = os.getId();
		this.dataAbertura = os.getDataAbertura();
		this.dataFechamento = os.getDataFechamento();
		this.prioridade = os.getPrioridade().getCod();
		this.observacoes = os.getObservacoes();
		this.status = os.getStatus().getCod();
		this.cliente = os.getCliente().getId();
		this.tecnico = os.getTecnico().getId();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataAbertura() {
		return dataAbertura;
	}

	public void setDataAbertura(LocalDateTime dataAbertura) {
		this.dataAbertura = dataAbertura;
	}

	public LocalDateTime getDataFechamento() {
		return dataFechamento;
	}

	public void setDataFechamento(LocalDateTime dataFechamento) {
		this.dataFechamento = dataFechamento;
	}

	public Integer getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Integer prioridade) {
		this.prioridade = prioridade;
	}

	public String getObservacoes() {
		return observacoes;
	}

	public void setObservacoes(String observacoes) {
		this.observacoes = observacoes;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Long getCliente() {
		return cliente;
	}

	public void setCliente(Long cliente) {
		this.cliente = cliente;
	}

	public Long getTecnico() {
		return tecnico;
	}

	public void setTecnico(Long tecnico) {
		this.tecnico = tecnico;
	}

	
	
	

}
