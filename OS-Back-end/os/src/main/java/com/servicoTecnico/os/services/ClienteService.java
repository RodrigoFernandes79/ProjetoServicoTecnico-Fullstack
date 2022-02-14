package com.servicoTecnico.os.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.servicoTecnico.os.dtos.ClienteDTO;
import com.servicoTecnico.os.models.Cliente;
import com.servicoTecnico.os.repositories.ClienteRepository;

@Service
public class ClienteService {

	
	@Autowired
	private ClienteRepository clienteRepository;



	public Cliente criarCliente(Cliente cliente) {
		
		
		ClienteDTO newObj = new ClienteDTO(cliente);
		Optional<Cliente> cpf = clienteRepository.findClienteByCpf(newObj.getCpf());
		
		if(cpf.isPresent()) {
			throw new DataIntegrityViolationException("CPF JÁ EXISTE NA BASE DE DADOS!");
		}else {
			Cliente obj = clienteRepository.save(cliente);
			
			return obj;
		}
			
	}



	public Cliente encontraClientePorId(Long id) {
		
		Optional<Cliente> obj = clienteRepository.findById(id);
		obj.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID " + id+ " NÃO PÔDE SER ENCONTRADO!" ));
		return obj.get();
	}



	public List<Cliente> listarClientes() {
		List<Cliente> obj = clienteRepository.findAll();
		
		return obj;
	}



	public Cliente alterarClientePorId(@Valid ClienteDTO clienteDTO, Long id) {
		Optional<Cliente> cpf = clienteRepository.findClienteByCpf(clienteDTO.getCpf());

		if(cpf.isPresent()&& cpf.get().getId() != id) {
			throw new DataIntegrityViolationException("CPF JÁ EXISTE NA BASE DE DADOS!");
	}
		
	return  clienteRepository.findById(id)
				.map(obj->{
					obj.getId();
					obj.setNome(clienteDTO.getNome());
					obj.setCpf(clienteDTO.getCpf());
					obj.setTelefone(clienteDTO.getTelefone());
					Cliente cl = clienteRepository.save(obj);
					
					
					return cl;
					
				}).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Id "+ id+ " NÃO PÔDE SER ENCONTRADO!"));
				
		
	
	
	}



	public void deletarClientePorId(Long id) {
		clienteRepository.findById(id)
		.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"ID "+id+" NÃO PÔDE SER ENCONTRADO!"));
		try {
		clienteRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("CLIENTE NÃO PODE SER DELETADO! POSSUI ORDENS DE SERVIÇO EM ABERTO");
		}
	}	
	}
	

