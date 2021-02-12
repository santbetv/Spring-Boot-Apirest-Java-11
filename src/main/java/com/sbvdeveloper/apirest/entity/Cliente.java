package com.sbvdeveloper.apirest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * Vamos a utilizar API Java Bean Validation: Especificación JSR-380 Este como
 * lo utilizamos en spring funciona de manera interna tener presente tener la
 * implementacion en el pom
 * 
 * 
 * @author rizzoli
 *
 */

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty(message = "no puede estar vacio")
	@Size(min = 4, max = 12, message = "el tamaño debe de estar entre 4 y 12")
	@Column(nullable = false) // para que no se pueda enviar vacio sobre la db
	private String nombre;

	@NotEmpty(message = "no puede estar vacio")
	private String apellido;

	@NotEmpty(message = "no puede estar vacio")
	@Email(message = "no es una dirección de correo bien formada")
	@Column(nullable = false, unique = true) // para que no se pueda enviar vacio, ni poder repetir correo sobre la db
	private String email;

	private LocalDateTime fecha;// Nuevos valores de Java8 en adelante

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fecha="
				+ fecha + "]";
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -1614807044782598669L;

}
