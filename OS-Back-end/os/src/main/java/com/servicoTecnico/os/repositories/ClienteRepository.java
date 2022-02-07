package com.servicoTecnico.os.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.servicoTecnico.os.models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}