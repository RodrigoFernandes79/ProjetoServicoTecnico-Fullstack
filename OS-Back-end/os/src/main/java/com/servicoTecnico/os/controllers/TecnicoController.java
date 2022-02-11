package com.servicoTecnico.os.controllers;

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

import com.servicoTecnico.os.dtos.TecnicoDTO;
import com.servicoTecnico.os.models.Tecnico;
import com.servicoTecnico.os.services.TecnicoService;
@CrossOrigin("*")
@RestController
@RequestMapping("/tecnicos")
public class TecnicoController {
	
	@Autowired
	private TecnicoService tecnicoService;
	
	
	
	@PostMapping
	ResponseEntity<TecnicoDTO> criarTecnico(@Valid @RequestBody Tecnico tecnico){
		
		
		Tecnico obj = tecnicoService.criarTecnico(tecnico);
		
		TecnicoDTO newObj = new TecnicoDTO(obj);
		
		
	return ResponseEntity.status(HttpStatus.CREATED).body(newObj);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Tecnico> encontraTecnicoPorId(@PathVariable Long id){
		Tecnico obj = tecnicoService.encontraTecnicoPorId(id);
		
		
		
		return ResponseEntity.ok().body(obj);
	}
	
	@GetMapping
	ResponseEntity<List<Tecnico>> listarTecnicos(){

		List<Tecnico> obj = tecnicoService.listarTecnicos();
		
		return ResponseEntity.ok().body(obj);

	}
	
	@PutMapping("/{id}")
	ResponseEntity<Tecnico> alteraTecnicoPorId(@Valid @RequestBody TecnicoDTO tecnicoDTO , @PathVariable Long id){
		
		
		Tecnico obj = tecnicoService.alterarTecnicoPorId(tecnicoDTO,id);
		
		
		
		return ResponseEntity.ok().body(obj);
		
		
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteTecnicoPorId(@PathVariable Long id) {
		tecnicoService.deleteTecnicoPorId(id);
		
	}
	
}


