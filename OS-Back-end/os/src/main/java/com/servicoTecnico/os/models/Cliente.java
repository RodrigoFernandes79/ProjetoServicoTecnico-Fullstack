package com.servicoTecnico.os.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.servicoTecnico.os.dtos.ClienteDTO;

@Entity
public class Cliente extends Pessoa {
	
	@OneToMany(mappedBy = "cliente")
	@JsonIgnore
	private List<OrdemServico> ordemServico = new ArrayList<>();

	public Cliente() {
		super();

	}

	public Cliente(Long id, String nome, String cpf, String telefone) {
		super(id, nome, cpf, telefone);

	}
	

	public List<OrdemServico> getOrdemServico() {
		return ordemServico;
	}

	public void setOrdemServico(List<OrdemServico> ordemServico) {
		this.ordemServico = ordemServico;
	}

}
