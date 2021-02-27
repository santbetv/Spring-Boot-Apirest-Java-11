package com.sbvdeveloper.apirest.sevice;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.entity.Factura;
import com.sbvdeveloper.apirest.entity.Region;

/**
 * Contrato del CRUD, Cuando tiene diversas interface sobre una misma interfas es
 * un Repository Manager tienen algo en comun y se pueden colar sobre la misma
 * 
 * @author rizzoli
 *
 */
public interface IClienteService {

	public List<Cliente> findAll();

	public Page<Cliente> findAll(Pageable s);

	public Cliente findById(Long id);

	public Cliente save(Cliente cliente);

	public void delete(Long id);

	public List<Region> findAllRegiones();

	public Region buscarRegionXId(Long id);
	
	public Factura findFacturaById(Long id);
	
	public Factura saveFactura(Factura factura);
	
	public void deleteFacturaById(Long id);
}
