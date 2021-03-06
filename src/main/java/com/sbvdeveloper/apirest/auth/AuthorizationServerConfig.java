package com.sbvdeveloper.apirest.auth;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

/**
 * Segunda
 * 
 * Clase de configuracion para OAuth2 y JWT
 * 
 * 
 * @author rizzoli
 *
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private InfoAdicionalToken infoAdicionalToken;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	// Realizar implemetacion en clase SpringSecurityConfig, para utlizar metodo por
	// @Bean
	@Autowired
	@Qualifier("authenticationManager")
	private AuthenticationManager authenticationManager;

	/**
	 * Configuracion para permisos de endpoint oauth/token y generarlo, despues
	 * verificar su token y su firma
	 * 
	 */
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {

		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
	}

	/**
	 * Doble autenticacion
	 * 
	 * 
	 * Metodo que brinda la oportunidad de configurar los cliente que consumen mi
	 * servicio, no solo con los usuarios de la aplicacion sin tambien credenciales
	 * obligatorias de cada frontend
	 * 
	 */
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {

		/**
		 * tipo de almacenamiento inMemory, se le pasa el nombre de tipo de app username
		 * pero de la aplicacion, se le pasa la contraseña de la app, se le pasa los
		 * permisos, se le pasa tipo de autorizacion por usuario y contra mas
		 * refresh_token un token renovado, pasar cuanto queremos que dure el token en
		 * segundos tanto para el normal como el refresh
		 * 
		 * 
		 */

		// duplicar este si es desde otra app react, vue, movil ... etc
		clients.inMemory().withClient("angularapp").secret(passwordEncoder.encode("12345")).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").and().withClient("react")
				.secret(passwordEncoder.encode("12345")).scopes("read", "write")
				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600 * 24)
				.refreshTokenValiditySeconds(3600);

//		clients.inMemory().withClient("fullapp").secret(passwordEncoder.encode("2021")).scopes("read", "write")
//				.authorizedGrantTypes("password", "refresh_token").accessTokenValiditySeconds(3600 * 24)
//				.refreshTokenValiditySeconds(3600);

	}

	/**
	 * Metodo que se sobre escribe para dar funcionalidad Metodo que se encarga de
	 * proceso de autenticacion y validar el token validando rutas
	 * 
	 * accessTokenConverter= maneja datos de autenticacion user, roles, cleans,
	 * datos del payload...traduce los datos del token, tokenStore=componente que
	 * guarda los datos se pude colocar o no ya que se realiza implicito.
	 * 
	 */
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

		//Unimos los datos de defectos con los datos nuevos
		TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();
		//accessTokenConverter() retorna el jwt
		tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionalToken, accessTokenConverter()));
		
		
		endpoints.authenticationManager(authenticationManager).tokenStore(tokenStore())
				.accessTokenConverter(accessTokenConverter()).tokenEnhancer(tokenEnhancerChain);
	}

	@Bean
	public JwtTokenStore tokenStore() {
		JwtTokenStore jwtTokenStore = new JwtTokenStore(accessTokenConverter());
		return jwtTokenStore;
	}

	/**
	 * 
	 * Se crea metodo desde linea configure(AuthorizationServerEndpointsConfigurer
	 * endpoints) Este metodo trabaja por debajo con toda la implentacion de JWT
	 * para codificar y decodificar los datos, siendo el firmante del token con
	 * certificado RSA
	 * 
	 * @return
	 */
	@Bean
	public JwtAccessTokenConverter accessTokenConverter() {
		JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
		jwtAccessTokenConverter.setSigningKey(JwtConfig.RSA_PRIVADA_UBU);
		jwtAccessTokenConverter.setVerifierKey(JwtConfig.RSA_PUBLICA_UBU);
		return jwtAccessTokenConverter;
	}

}
