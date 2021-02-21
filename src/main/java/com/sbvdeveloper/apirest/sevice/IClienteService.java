package com.sbvdeveloper.apirest.sevice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.entity.Region;

//Contrato del CRUD
public interface IClienteService {

	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable s);
	
	public Cliente findById(Long id);	
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Region> findAllRegiones();
	
	public Region buscarRegionXId(Long id);
	
	
	
}
