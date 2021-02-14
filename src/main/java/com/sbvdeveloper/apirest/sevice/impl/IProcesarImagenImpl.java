package com.sbvdeveloper.apirest.sevice.impl;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.sbvdeveloper.apirest.sevice.IProcesarImagen;

@Service
public class IProcesarImagenImpl implements IProcesarImagen {

	private final Logger log = LoggerFactory.getLogger(IProcesarImagenImpl.class);

	@Autowired
	private Environment env;

	@Override
	public Resource cargarImagen(String nombreFoto) throws MalformedURLException {
		Path rutaArchivo = getPath(nombreFoto);
		log.info(rutaArchivo.toString());

		Resource recurso = null;

		recurso = new UrlResource(rutaArchivo.toUri());

		// valido si existe y si es legible o leible
		if (!recurso.exists() && !recurso.isReadable()) {
			rutaArchivo = Paths.get(env.getProperty("RUTA_RECURSOS_IMG")).resolve("no-usuario.png").toAbsolutePath();

			recurso = new UrlResource(rutaArchivo.toUri());
			log.error("Error no se pudo cargar la imagen: " + nombreFoto);
		}
		return recurso;
	}

	@Override
	public String copiarImagen(MultipartFile archivo) throws IOException {

		// Se concatena con clase random para asegurar img
		String nombreArchivo = UUID.randomUUID().toString() + "_" + archivo.getOriginalFilename().replace(" ", "");
		Path rutaArchivo = getPath(nombreArchivo);

		log.info(rutaArchivo.toString());

		Files.copy(archivo.getInputStream(), rutaArchivo);

		return nombreArchivo;
	}

	@Override
	public boolean eliminarImagen(String nombreFotoAnterior) {

		// valido si existe foto
		if (nombreFotoAnterior != null && nombreFotoAnterior.length() > 0) {
			// identificar ruta completa de foto
			Path rutaFotoAnterior = Paths.get("src/main/resources/upload").resolve(nombreFotoAnterior).toAbsolutePath();
			// se convierte en archivo
			File archivoFotoAnterior = rutaFotoAnterior.toFile();
			// validamos que exista el archivo y se pueda eliminar
			if (archivoFotoAnterior.exists() && archivoFotoAnterior.canRead()) {
				archivoFotoAnterior.delete();
				return true;
			}
		}

		return false;
	}

	// metodo simple para obtener el path
	@Override
	public Path getPath(String nombreFoto) {
		return Paths.get(env.getProperty("RUTA_RECURSOS")).resolve(nombreFoto).toAbsolutePath();

	}

}
