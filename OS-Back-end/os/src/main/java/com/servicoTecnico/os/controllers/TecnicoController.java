package com.servicoTecnico.os.controllers;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.servicoTecnico.os.dtos.TecnicoDTO;

import com.servicoTecnico.os.models.Tecnico;
import com.servicoTecnico.os.repositories.TecnicoRepository;
import com.servicoTecnico.os.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@PostMapping
	ResponseEntity<TecnicoDTO> criarTecnico(@Valid @RequestBody Tecnico tecnico){
		
		TecnicoDTO DTO = new TecnicoDTO(tecnico);
		Optional<Tecnico> cpf = tecnicoRepository.findTecnicoByCpf(DTO.getCpf());
		if(cpf.isPresent()){
			throw new DataIntegrityViolationException("CPF Já EXISTE!");	
			
	}else{
		Tecnico obj = tecnicoService.criarTecnico(tecnico);
		
		TecnicoDTO newObj = new TecnicoDTO(obj);
		
		
	return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
}
	

}