package com.servicoTecnico.os.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.servicoTecnico.os.dtos.TecnicoDTO;
import com.servicoTecnico.os.models.Tecnico;
import com.servicoTecnico.os.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	public Tecnico criarTecnico(  @Valid TecnicoDTO tecnicoDTO) {
		
		Optional<Tecnico> cpf = tecnicoRepository.findTecnicoByCpf(tecnicoDTO.getCpf());
		if(cpf.isPresent()){
			throw new DataIntegrityViolationException("CPF Já EXISTE!");	
			
	}else{
		
		Tecnico obj = new Tecnico(null, tecnicoDTO.getNome(), tecnicoDTO.getCpf(), tecnicoDTO.getTelefone());
				
		Tecnico newObj = tecnicoRepository.save(obj);	
		
		
		return newObj;
	}
		
	}

	public Tecnico encontraTecnicoPorId(Long id) {
	
	Optional<Tecnico> obj = tecnicoRepository.findById(id);
		obj.orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND,"id " + id + " não encontrado!"));
		return obj.get() ;
	
	   
	}

	public List<TecnicoDTO> listarTecnicos() {
		List<Tecnico> obj = tecnicoRepository.findAll();
		List<TecnicoDTO> newObj = new ArrayList(obj);
		return newObj;
	}

	public Tecnico alterarTecnicoPorId(@Valid TecnicoDTO tecnicoDTO, Long id) {
		
		Optional<Tecnico> cpf = tecnicoRepository.findTecnicoByCpf(tecnicoDTO.getCpf());
		
		if(cpf.isPresent()&& cpf.get().getId() != id){
			throw new DataIntegrityViolationException("CPF Já EXISTE!");	
			
		}
		return tecnicoRepository.findById(id)
				.map(obj ->{
					obj.setNome(tecnicoDTO.getNome());
					obj.setCpf(tecnicoDTO.getCpf());
					obj.setTelefone(tecnicoDTO.getTelefone());
					Tecnico tc = tecnicoRepository.save(obj);
					
					
					return tc;
					
				}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "ID: "+id+ " não encontrado!"));
				
				
	}

	public void deleteTecnicoPorId(Long id) {
		tecnicoRepository.findById(id)
		.orElseThrow(()->  new ResponseStatusException(HttpStatus.NOT_FOUND,"id " + id + " não encontrado!"));
		try {
		tecnicoRepository.deleteById(id);
		}catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("TÉCNICO NÃO PODE SER DELETADO! POSSUI ORDENS DE SERVIÇO EM ABERTO!");
		}
		
	}
	}

	

