
package com.servicoTecnico.os.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.servicoTecnico.os.models.Tecnico;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long>{
	
	@Query(value="SELECT * FROM pessoa where cpf = :cpf", nativeQuery =true)
	Optional<Tecnico> findTecnicoByCpf(@Param(value="cpf") String cpf);

}

