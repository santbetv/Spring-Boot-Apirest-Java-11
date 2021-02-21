package com.sbvdeveloper.apirest.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	/**
	 * Tercera
	 * 
	 * Estas reglas es por el lado de OAuth2
	 * 
	 * Metodo que permite implementar todas las reglas de seguridad es para las
	 * reglas de acceso a los recursos y rutas, aquí realmente damos los permisos a
	 * las url y accesos según roles
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**").permitAll()
				.antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER","ADMIN")//no requiere rol por debajo se concatena
				.antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER","ADMIN")
				.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
				.antMatchers("/api/clientes/**").hasRole("ADMIN")
				.anyRequest().authenticated();//todas las rutas que no se indiquen, solo para usuarios autenticados
				//.antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")//solo un rol
				//.antMatchers("/api/clientes/**").hasRole("ADMIN")//sin http se aplica para todos los metodos
	}

	
	//Ejemplo simple de petiociones get
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/regiones").permitAll().anyRequest().authenticated();
//	}

}
