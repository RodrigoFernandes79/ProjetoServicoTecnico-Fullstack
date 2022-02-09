package com.servicoTecnico.os.dtos;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;

import com.servicoTecnico.os.models.Cliente;

public class ClienteDTO {
	
	private Long id;
	@Column(unique = true, nullable = false)
	@NotBlank(message= "Campo Obrigatório!")
	private String nome;
	
	@CPF(message = "CPF inválido!")
	@NotBlank(message= "Campo Obrigatório!")
	@Column(unique = true, nullable = false)
	private String cpf;
	
	@NotBlank(message= "Campo Obrigatório!")
	private String telefone;

	public ClienteDTO() {
		super();
		
	}

	public ClienteDTO(Cliente cliente) {
		super();
		this.id = cliente.getId();
		this.nome = cliente.getNome();
		this.cpf = cliente.getCpf();
		this.telefone = cliente.getTelefone();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	

}
