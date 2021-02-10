package com.sbvdeveloper.apirest.sevice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.repository.IClienteRepository;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Override
	@Transactional(readOnly = true)//
	public List<Cliente> findAll() {

		return clienteRepository.findAll();
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
