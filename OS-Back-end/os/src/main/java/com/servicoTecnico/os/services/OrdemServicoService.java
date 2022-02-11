package com.servicoTecnico.os.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.servicoTecnico.os.dtos.OrdemServicoDTO;
import com.servicoTecnico.os.enums.Prioridade;
import com.servicoTecnico.os.enums.Status;
import com.servicoTecnico.os.models.Cliente;
import com.servicoTecnico.os.models.OrdemServico;
import com.servicoTecnico.os.models.Tecnico;
import com.servicoTecnico.os.repositories.OrdemServicoRepository;

@Service
public class OrdemServicoService {
	
	@Autowired
	private OrdemServicoRepository osRepository;
	
	@Autowired
	private TecnicoService tcService;
	
	@Autowired
	private ClienteService clService;

	public OrdemServico criarOS(@Valid OrdemServicoDTO os) {
		OrdemServico obj = new OrdemServico();
		obj.setPrioridade(Prioridade.toEnum(os.getPrioridade()));
		obj.setObservacoes(os.getObservacoes());
		obj.setId(os.getId());
		obj.setStatus(Status.toEnum(os.getStatus()));
		
		Tecnico tc = tcService.encontraTecnicoPorId(os.getTecnico());
		Cliente cl = clService.encontraClientePorId(os.getCliente());
		
		obj.setTecnico(tc);
		obj.setCliente(cl);
		
		if(obj.getStatus().getCod().equals(2)) {
			obj.setDataFechamento(LocalDateTime.now());
		}
		
		OrdemServico newobj = osRepository.save(obj);
		return newobj;
	}

	public List<OrdemServicoDTO> listarOS() {
		
		List<OrdemServico> obj = osRepository.findAll();
		
		List<OrdemServicoDTO> newObj = new  ArrayList(obj);	
		return newObj;
	}

	public OrdemServico listarOSPorId(Long id) {
		
		Optional<OrdemServico> obj = osRepository.findById(id);
		obj.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+id+ " NÃO ENCONTRADO!"));
		
		
		return obj.get();
	}

	public OrdemServico alteraOs(@Valid OrdemServicoDTO os) {
		 Optional<OrdemServico> object = osRepository.findById(os.getId());
		 OrdemServico obj = new OrdemServico();
			obj.setPrioridade(Prioridade.toEnum(os.getPrioridade()));
			obj.setObservacoes(os.getObservacoes());
			obj.setId(os.getId());
			obj.setStatus(Status.toEnum(os.getStatus()));
			
			Tecnico tc = tcService.encontraTecnicoPorId(os.getTecnico());
			Cliente cl = clService.encontraClientePorId(os.getCliente());
			
			obj.setTecnico(tc);
			obj.setCliente(cl);
			
			if(obj.getStatus().getCod().equals(2)) {
				obj.setDataFechamento(LocalDateTime.now());
			}
			
			OrdemServico newobj = osRepository.save(obj);
			object.orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"ID: "+os.getId()+ " NÃO ENCONTRADO!"));
			return newobj;
		
		
	}
	
	

}
