package com.sbvdeveloper.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.entity.Region;


public interface IClienteRepository extends JpaRepository<Cliente, Long> {
	
	/**
	 * Mapeo del metodo con jpql
	 * tambien se puede por nombre de atributos y complementos de jpa
	 * como trabajamos con objetos dar el nombre del objeto
	 * @return
	 */
	@Query("from Region")
	public List<Region> findAllRegiones();

}
