package com.servicoTecnico.os.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.servicoTecnico.os.dtos.TecnicoDTO;
import com.servicoTecnico.os.models.Tecnico;
import com.servicoTecnico.os.repositories.TecnicoRepository;

@Service
public class TecnicoService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;

	public Tecnico criarTecnico(Tecnico tecnico) {
		TecnicoDTO DTO = new TecnicoDTO(tecnico);
		Optional<Tecnico> cpf = tecnicoRepository.findTecnicoByCpf(DTO.getCpf());
		if(cpf.isPresent()){
			throw new DataIntegrityViolationException("CPF Já EXISTE!");	
			
	}else{
		
		
		Tecnico obj = tecnicoRepository.save(tecnico);	
		
		
		return obj;
	}
		
	}

}
	

