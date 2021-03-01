package com.sbvdeveloper.apirest.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.entity.Factura;
import com.sbvdeveloper.apirest.entity.Producto;
import com.sbvdeveloper.apirest.entity.Region;
import com.sbvdeveloper.apirest.repository.IClienteRepository;
import com.sbvdeveloper.apirest.repository.IFacturaRepository;
import com.sbvdeveloper.apirest.repository.IProductoRepository;
import com.sbvdeveloper.apirest.sevice.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private IClienteRepository clienteRepository;

	@Autowired
	private IFacturaRepository facturaRepository;

	@Autowired
	private IProductoRepository productoRepository;

	@Override
	@Transactional(readOnly = true) //
	public List<Cliente> findAll() {

		return clienteRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) //
	public Page<Cliente> findAll(Pageable s) {

		return clienteRepository.findAll(s);
	}

	// Transactional de lectura
	@Override
	@Transactional(readOnly = true) //
	public Cliente findById(Long id) {
		// si lo encuentra retorna objeto si no null
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

	@Override
	@Transactional(readOnly = true) //
	public List<Region> findAllRegiones() {

		return clienteRepository.findAllRegiones();
	}

	@Override
	public Region buscarRegionXId(Long id) {

		return clienteRepository.buscarRegionXId(id);

	}

	@Override
	@Transactional(readOnly = true) //
	public Factura findFacturaById(Long id) {
		return facturaRepository.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Factura saveFactura(Factura factura) {
		return facturaRepository.save(factura);
	}

	@Override
	@Transactional
	public void deleteFacturaById(Long id) {
		facturaRepository.deleteById(id);

	}

	@Override
	@Transactional(readOnly = true) //
	public List<Producto> findProductoByNombre(String term) {
		return productoRepository.findByNombreStartingWithIgnoreCase(term);
	}

}
