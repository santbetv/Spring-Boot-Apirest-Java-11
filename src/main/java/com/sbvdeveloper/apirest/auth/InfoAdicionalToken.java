package com.sbvdeveloper.apirest.auth;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import com.sbvdeveloper.apirest.entity.Usuario;
import com.sbvdeveloper.apirest.repository.IUsuarioRepository;
import com.sbvdeveloper.apirest.sevice.IUsuarioService;

/**
 * Clase que permite agregar valores adicionales al token
 * 
 * @author rizzoli
 *
 */
@Component
public class InfoAdicionalToken implements TokenEnhancer{

	
	@Autowired
	private IUsuarioService usuarioService;
	
	
	/**
	 * Token potenciador que permite agragar nueva informacion 
	 * 
	 * 
	 */
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		
		Usuario usuario = usuarioService.findByUsername(authentication.getName());
		
		Map<String, Object> info=  new HashMap<>();
		info.put("info adicional: ", "Hola que tal: ".concat(authentication.getName()));
		info.put("id_usuario: ", usuario.getId());
		info.put("usuario: ", usuario.getUsername());
		info.put("nombre: ", usuario.getNombre());
		info.put("apellido: ", usuario.getApellido());
		info.put("email: ", usuario.getEmail());
		
		//Se realiza tipo castig para pasar el dato
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
		
		return accessToken;
	}

}	
