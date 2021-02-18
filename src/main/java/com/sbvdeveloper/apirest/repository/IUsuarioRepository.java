package com.sbvdeveloper.apirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sbvdeveloper.apirest.entity.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

	//Con componente Spring
	public Usuario findByUsername(String username);

	//Con componente JPQL
	@Query("select u from Usuario u where u.username=?1")
	public Usuario buucarXUsername(String username);
	
	@Query("select u from Usuario u where u.username=?1 and u.password=?2")
	public Usuario buucarXUsername2(String username);

	//Otro buscar con dos parametros
	public Usuario findByUsernameAndPassword(String username, String password);
}
