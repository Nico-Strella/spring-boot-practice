package com.packt.microservices.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public List<Trabajo> getTrabajosEnviados(Integer id) {
		return repository.findAllTrabajosEnInvestigacionEnviados(id);
	}
}
