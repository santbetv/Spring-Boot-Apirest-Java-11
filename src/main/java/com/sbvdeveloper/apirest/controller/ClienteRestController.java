package com.sbvdeveloper.apirest.controller;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.sevice.IClienteService;

//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.GET })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	
	/**
	 * Cuando se declara con tipo generico interface o abstrac
	 * va a buscar el primer candidato, una clase concreta que implemente esta interface y la va
	 * inyectar, ya cuanso se implemente mas de un Service con la misma interface
	 * colocar en Autowired, del controlador Qualifier, indicando que Service
	 * entra a funcionar.
	 */
	@Autowired
	IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();

	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> datos = new HashMap<>();

		try {
			cliente = clienteService.findById(id);
			//Exception que permite utilizada de getMostSpecificCause
		} catch (DataAccessException e) {
			datos.put("mensaje", "Error al realizar la consulta en al base de datos");
			datos.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		if (cliente == null) {
			datos.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" No esxite en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.NOT_FOUND);
		}
		datos.put("cliente", cliente);
		datos.put("mensaje", "Exito en la busqueda!");
		

		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.OK);
	}

	@PostMapping("/clientes")
	public ResponseEntity<?> create(@RequestBody Cliente cliente) {
		
		Cliente clienteNew = null;
		Map<String, Object> datos = new HashMap<>();
		
		
		try {
			cliente.setFecha(LocalDateTime.now());
			clienteNew = clienteService.save(cliente);
			//Exception que permite utilizada de getMostSpecificCause
		} catch (DataAccessException e) {
			datos.put("mensaje", "Error al realizar insertar en la base datos");
			datos.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		datos.put("mensaje", "el cliente ha sido creado con éxito!");
		datos.put("cliente", clienteNew);
		
		
		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.CREATED);
	}

	@PutMapping("/clientes/{id}")
	public ResponseEntity<?> update(@RequestBody Cliente cliente, @PathVariable Long id) {
		
		Cliente clienteBuscado = clienteService.findById(id);
		Cliente clienteUpdate= null;
		Map<String, Object> datos = new HashMap<>();
		
		if (clienteBuscado == null) {
			datos.put("mensaje", "El cliente ID: ".concat(id.toString().concat(" No esxite en la base de datos!")));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.NOT_FOUND);
		}

		try {
			clienteBuscado.setApellido(cliente.getApellido());
			clienteBuscado.setNombre(cliente.getNombre());
			clienteBuscado.setEmail(cliente.getEmail());
			clienteBuscado.setFecha(cliente.getFecha());
			
			clienteUpdate = clienteService.save(clienteBuscado);
			//Exception que permite utilizada de getMostSpecificCause
		} catch (DataAccessException e) {
			datos.put("mensaje", "Error al realizar actilizacion en la base datos");
			datos.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		datos.put("mensaje", "el cliente ha sido actualizado con éxito!");
		datos.put("cliente", clienteUpdate);
		
		
		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.CREATED);
	}

	@DeleteMapping("/clientes/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		
		//No es necesario validar si el cliente existe, ya que desde el ServiceImpl, lo valido
		
		Map<String, Object> datos = new HashMap<>();
		
		try {
			
			clienteService.delete(id);
			//Exception que permite utilizada de getMostSpecificCause
		} catch (DataAccessException e) {
			datos.put("mensaje", "Error al realizar eliminacion en la base datos");
			datos.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		datos.put("mensaje", "el cliente ha sido eliminado con éxito!");
		
		
		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.OK);
	}
}
