package com.sbvdeveloper.apirest.sevice;

import com.sbvdeveloper.apirest.entity.Usuario;

public interface IUsuarioService {
	
	public Usuario findByUsername(String username);

}
