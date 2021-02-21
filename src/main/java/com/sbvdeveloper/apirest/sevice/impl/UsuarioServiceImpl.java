package com.sbvdeveloper.apirest.sevice.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sbvdeveloper.apirest.entity.Usuario;
import com.sbvdeveloper.apirest.repository.IUsuarioRepository;
import com.sbvdeveloper.apirest.sevice.IUsuarioService;

/**
 * Se utiliza interface UserDetailsService para detallar lo que va hacer el
 * usuario
 * 
 * @author rizzoli
 *
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService, UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(UsuarioServiceImpl.class);

	@Autowired
	private IUsuarioRepository usuarioRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = usuarioRepository.findByUsername(username);

		if (usuario == null) {
			logger.error("Error en el login: no existe el usuario'" + username + "'en el sistema!");
			throw new UsernameNotFoundException("Error en el login: no existe el usuario'" + username + "'en el sistema!");
		}

		// Se gestiona los roles trabajando con el flujo y se agrega cleans, payload
		List<GrantedAuthority> authorities = usuario.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getNombre()))
				.peek(authority -> logger.info("Role: " + authority.getAuthority()))//pintando su rol al iterar
				.collect(Collectors.toList());

		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
				authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Usuario findByUsername(String username) {
		
		return usuarioRepository.findByUsername(username);
	}

}
