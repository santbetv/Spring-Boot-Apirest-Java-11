package com.sbvdeveloper.apirest.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.repository.IClienteRepository;
import com.sbvdeveloper.apirest.sevice.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)//
	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)//
	public Page<Cliente> findAll(Pageable s) {
		
		return clienteRepository.findAll(s);
	}
	

	// Transactional de lectura
	@Override
	@Transactional(readOnly = true)//
	public Cliente findById(Long id) {
		//si lo encuentra retorna objeto si no null
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		
		return clienteRepository.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}

	
	

}
