package com.sbvdeveloper.apirest.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

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

	@NotNull(message ="no puede estar vacio")
	private LocalDateTime fecha;// Nuevos valores de Java8 en adelante

	private String foto;
	
	
	/**
	 * FetchType.LAZY = Cada que se invoque region se realiza la carga
	 * @JoinColumn = propiedad que da el nombre manual a la llave FK
	 * @JsonIgnoreProperties = se genera una comunicacion de hibernate
	 * se debe de excluir, genera errores al comunicarse con su tabla por 
	 * su comunicacion (proxy)
	 * 
	 */
	@NotNull(message ="no puede estar vacio")
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "region_id")
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Region region;
	
	
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

	
	
	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	
	

	public Region getRegion() {
		return region;
	}

	public void setRegion(Region region) {
		this.region = region;
	}

	



	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", fecha="
				+ fecha + ", foto=" + foto + ", region=" + region + "]";
	}





	/**
	 * 
	 */
	private static final long serialVersionUID = -1614807044782598669L;

}
