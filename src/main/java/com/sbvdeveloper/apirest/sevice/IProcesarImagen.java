package com.sbvdeveloper.apirest.sevice;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IProcesarImagen {

	public Resource cargarImagen(String nombreFoto) throws MalformedURLException;
	public String copiarImagen(MultipartFile archivo) throws IOException;
	public boolean eliminarImagen(String nombreFoto);
	public Path getPath(String nombreFoto);
}
