package com.sbvdeveloper.apirest.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sbvdeveloper.apirest.entity.Cliente;
import com.sbvdeveloper.apirest.sevice.IClienteService;

//@CrossOrigin(origins = {"http://localhost:4200"})
@CrossOrigin(methods = { RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.GET })
@RestController
@RequestMapping("/api")
public class ClienteRestController {

	/**
	 * Cuando se declara con tipo generico interface o abstrac va a buscar el primer
	 * candidato, una clase concreta que implemente esta interface y la va inyectar,
	 * ya cuanso se implemente mas de un Service con la misma interface colocar en
	 * Autowired, del controlador Qualifier, indicando que Service entra a
	 * funcionar.
	 */
	@Autowired
	IClienteService clienteService;

	@GetMapping("/clientes")
	public List<Cliente> index() {
		return clienteService.findAll();
	}
	
	@GetMapping("/clientes/page/{page}")
	public Page<Cliente> paginadorWeb(@PathVariable Integer page) {
		Pageable pegeable = PageRequest.of(page, 4);
		return clienteService.findAll(pegeable);
	}

	@GetMapping("/clientes/{id}")
	public ResponseEntity<?> show(@PathVariable Long id) {
		Cliente cliente = null;
		Map<String, Object> datos = new HashMap<>();

		try {
			cliente = clienteService.findById(id);
			// Exception que permite utilizada de getMostSpecificCause
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

	/**
	 * Se utiliza notacion valid para que tome la config de notacion valid de la
	 * clase entity se implementa metodo normal y lambdas para mostrar los errores
	 * capturados BindingResult result, permite obtener los mensajes de error,
	 * siempre colocarlo despues del Objeto cliente, que toma los datos
	 * 
	 * 
	 * @param cliente
	 * @return
	 */
	@PostMapping("/clientes")
	public ResponseEntity<?> create(@Valid @RequestBody Cliente cliente, BindingResult result) {

		Cliente clienteNew = null;
		Map<String, Object> datos = new HashMap<>();

		// Porceso para validar atriputos en peticion
		if (result.hasErrors()) {
			/*
			 * List<String> errors = new ArrayList<>();
			 * 
			 * for (FieldError err : result.getFieldErrors()) {
			 * errors.add("El campo '"+err.getField()+"' " + err.getDefaultMessage()); }
			 */
			// Utilizo este para mejorar practicas de codigo
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			datos.put("errores", errors);

			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.BAD_REQUEST);
		}

		try {
			cliente.setFecha(LocalDateTime.now());
			clienteNew = clienteService.save(cliente);
			// Exception que permite utilizada de getMostSpecificCause
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
	public ResponseEntity<?> update(@Valid @RequestBody Cliente cliente, BindingResult result, @PathVariable Long id) {

		Cliente clienteBuscado = clienteService.findById(id);
		Cliente clienteUpdate = null;
		Map<String, Object> datos = new HashMap<>();

		// Porceso para validar atributos en peticion
		if (result.hasErrors()) {
			/*
			 * List<String> errors = new ArrayList<>();
			 * 
			 * for (FieldError err : result.getFieldErrors()) {
			 * errors.add("El campo '"+err.getField()+"' " + err.getDefaultMessage()); }
			 */
			// Utilizo este para mejorar practicas de codigo
			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			datos.put("errores", errors);

			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.BAD_REQUEST);
		}

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
			// Exception que permite utilizada de getMostSpecificCause
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

		// No es necesario validar si el cliente existe, ya que desde el ServiceImpl, lo
		// valido

		Map<String, Object> datos = new HashMap<>();

		try {

			clienteService.delete(id);
			// Exception que permite utilizada de getMostSpecificCause
		} catch (DataAccessException e) {
			datos.put("mensaje", "Error al realizar eliminacion en la base datos");
			datos.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		datos.put("mensaje", "el cliente ha sido eliminado con éxito!");

		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.OK);
	}
	
	
	@PostMapping("/clientes/upload")
	public ResponseEntity<?> subirImagen(@RequestParam("archivo") MultipartFile archivo, 
			@RequestParam("id") Long id){
		
		Map<String, Object> datos = new HashMap<>();
		
		Cliente cliente = clienteService.findById(id);
		
		Cliente clienteUpdate = null;
		
		if (!archivo.isEmpty()) {
			//Se concatena con clase random para asegurar img
			String nombreArchivo = UUID.randomUUID().toString() +"_"+ archivo.getOriginalFilename().replace(" ", "");
			Path rutaArchivo = Paths.get("src/main/resources/upload").resolve(nombreArchivo).toAbsolutePath();
			
			try {
				Files.copy(archivo.getInputStream(), rutaArchivo);
			} catch (IOException e) {
				datos.put("mensaje", "Error al subir la imagen del cliente  " + nombreArchivo);
				datos.put("error", e.getMessage().concat(": ").concat(e.getCause().getMessage()));
				return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			cliente.setFoto(nombreArchivo);
			
			clienteUpdate = clienteService.save(cliente);
			
			datos.put("cliente", clienteUpdate);
			datos.put("mensaje", "Has subido correctamente la imagen: " + nombreArchivo);
			
		}
		
		return new ResponseEntity<Map<String, Object>>(datos, HttpStatus.CREATED);
	}
}
