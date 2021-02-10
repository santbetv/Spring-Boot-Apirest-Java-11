package com.sbvdeveloper.apirest.sevice;

import java.util.List;

import com.sbvdeveloper.apirest.entity.Cliente;

//Contrato del CRUD
public interface IClienteService {

	public List<Cliente> findAll();
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
}
