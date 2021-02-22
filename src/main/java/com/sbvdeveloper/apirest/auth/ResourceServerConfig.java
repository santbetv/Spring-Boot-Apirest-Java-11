package com.sbvdeveloper.apirest.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
	 * 
	 * Esto es una configuracion sistematica, manual de permisos para endpoint
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception {
		/**
		 * Se configiran las rutas sistematicas o con anotaciones se implementan los
		 * cors en peticion de cliente
		 */
		http.authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/page/**", "/api/uploads/img/**", "/img")
				.permitAll().anyRequest().authenticated().and().cors().configurationSource(corsConfigurationSource());

//		  .antMatchers(HttpMethod.GET, "/api/clientes/{id}").hasAnyRole("USER","ADMIN")//no requiere ROLE_ por
//		  debajo se concatena .antMatchers(HttpMethod.POST, "/api/clientes/upload").hasAnyRole("USER","ADMIN")
//		  .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")
//		  .antMatchers("/api/clientes/**").hasRole("ADMIN")

// .antMatchers(HttpMethod.POST, "/api/clientes").hasRole("ADMIN")//solo un rol
// .antMatchers("/api/clientes/**").hasRole("ADMIN")//sin HttpMethod se aplica para todos los metodos

	}

	// Ejemplo simple de peticiones get
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/clientes", "/api/clientes/regiones").permitAll().anyRequest().authenticated();
//	}

//	@Bean
//	public CorsConfigurationSource corsConfigurationSource() {
//		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//		CorsConfiguration config = new CorsConfiguration();
//		config.setAllowCredentials(true);
//		config.addAllowedOrigin("*");
//		config.addAllowedHeader("*");
//		config.addAllowedMethod("OPTIONS");
//		config.addAllowedMethod("GET");
//		config.addAllowedMethod("POST");
//		config.addAllowedMethod("PUT");
//		config.addAllowedMethod("DELETE");
//		source.registerCorsConfiguration("/**", config);
//		System.out.println("PETICION CORS1 -->");
//		return  source;
//	}

	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Arrays.asList("*"));
		// config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowedHeaders(
				Arrays.asList("X-PINGOTHER", "Origin", "X-Requested-With", "Content-Type", "Accept", "Authorization"));
		source.registerCorsConfiguration("/**", config);// esto es para todas las rutas
		System.out.println("PETICION CORS2 -->");
		return source;
	}

	/**
	 * Se crear un filtro de cors para registrarlo en Spring, con prioridad alta
	 * 
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter() {
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(
				new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;

	}

}
