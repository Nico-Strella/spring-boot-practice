package com.packt.microservices.service;

import java.util.List;

import com.packt.microservices.entity.Trabajo;

public interface IUsuarioService {
	public List<Trabajo> getTrabajosEnviados(Integer id);
}
