package com.packt.microservices.usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(value="/trabajosEnviados/{id}", method=RequestMethod.GET, produces="application/json")
	public List<Trabajo> getTrabajosEnviadosById(@PathVariable("id") int id){
		return service.getTrabajosEnviados(id);
	}
}