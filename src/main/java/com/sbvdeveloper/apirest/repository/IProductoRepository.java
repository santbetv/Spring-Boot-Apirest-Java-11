package com.sbvdeveloper.apirest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbvdeveloper.apirest.entity.Producto;

public interface IProductoRepository extends JpaRepository<Producto, Long> {

	
	
	public List<Producto> findByNombreContainingIgnoreCase(String nombre);
	
	public List<Producto> findByNombreStartingWithIgnoreCase(String nombre);
	
	
	
	@Query("select p from Producto p where p.nombre like %?1%")
	public List<Producto> findByNombre(String term);
}
