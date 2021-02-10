package com.sbvdeveloper.apirest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//para que no se pueda enviar vacio
	@Column(nullable = false)
	private String nombre;
	private String apellido;
	//para que no se pueda enviar vacio, ni poder repetir correo
	@Column(nullable = false, unique = true)
	private String email;
	// Nuevos valores de Java8 en adelante
	private LocalDateTime fecha;

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
