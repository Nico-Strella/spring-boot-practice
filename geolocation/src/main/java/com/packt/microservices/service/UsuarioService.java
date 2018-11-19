package com.packt.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.packt.microservices.dao.IUsuarioDAO;
import com.packt.microservices.entity.Trabajo;

@Service
public class UsuarioService implements IUsuarioService{
	
	@Autowired
	private IUsuarioDAO usuarioDAO;

	@Override
	public List<Trabajo> getTrabajosEnviados(Integer id) {
		return usuarioDAO.findAllTrabajosEnInvestigacionEnviados(id);
	}
}
