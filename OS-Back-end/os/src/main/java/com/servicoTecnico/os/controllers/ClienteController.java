package com.servicoTecnico.os.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.servicoTecnico.os.dtos.ClienteDTO;
import com.servicoTecnico.os.models.Cliente;
import com.servicoTecnico.os.services.ClienteService;


@CrossOrigin("*")
@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;
	
	
	@PostMapping 
	ResponseEntity<ClienteDTO> criarCliente(@Valid @RequestBody Cliente cliente){
		
		Cliente obj = clienteService.criarCliente(cliente);
		
		ClienteDTO newObj = new ClienteDTO(obj);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<ClienteDTO> encontraClientePorId(@PathVariable Long id){
		
		Cliente obj = clienteService.encontraClientePorId(id);
		
		ClienteDTO newObj = new ClienteDTO(obj);
		
		return ResponseEntity.ok().body(newObj);
	}
	
	@GetMapping
	ResponseEntity<List<ClienteDTO>> listarClientes(){
		List<Cliente> obj = clienteService.listarClientes();
		List<ClienteDTO> newObj = new ArrayList(obj);
		
		return ResponseEntity.ok().body(newObj);
	}
	
	@PutMapping("/{id}")
	ResponseEntity<ClienteDTO> alterarClientePorId(@Valid @RequestBody ClienteDTO clienteDTO, @PathVariable Long id){
		
		Cliente obj = clienteService.alterarClientePorId(clienteDTO,id);
		ClienteDTO newObj = new ClienteDTO(obj);
		
		return ResponseEntity.ok().body(newObj);
		
	}
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@DeleteMapping("/{id}")
	public void deletarClientePorId(@PathVariable Long id) {
	 
		clienteService.deletarClientePorId(id);
	}

}
