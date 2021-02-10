package com.sbvdeveloper.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbvdeveloper.apirest.entity.Cliente;


public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	
	

}
