package com.packt.microservices.service;

import java.util.List;

import com.packt.microservices.entity.Trabajo;
import com.packt.microservices.entity.Usuario;

public interface IUsuarioService {
	public List<Trabajo> getTrabajosEnviados(Integer id);
	
	public Usuario getUsuario(Integer id);
}
