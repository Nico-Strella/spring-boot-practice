package com.packt.microservices.usuario;

import java.util.List;

public interface UsuarioService {
	public List<Trabajo> getTrabajosEnviados(Integer id);
}
