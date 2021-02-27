package com.sbvdeveloper.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sbvdeveloper.apirest.entity.Factura;

public interface IFacturaRepository extends JpaRepository<Factura, Long> {

	
	
}
