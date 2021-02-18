package com.sbvdeveloper.apirest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "roles")
public class Role implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, length = 20)
	private String nombre;
	
	/**
	 * Nombre del atributo de la otra clase, indicando mapeado por roles
	 * para el ejemplo
	 * @return
	 */
	/*@ManyToMany(mappedBy = "roles")
	public Long getId() {
		return id;
	}*/

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", nombre=" + nombre + "]";
	}
	
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 4888093317731110608L;

}
