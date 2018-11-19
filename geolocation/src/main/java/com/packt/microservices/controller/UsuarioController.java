package com.packt.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.microservices.entity.Trabajo;
import com.packt.microservices.entity.Usuario;
import com.packt.microservices.service.IUsuarioService;

@RestController
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	@GetMapping("trabajosEnviados/{id}")
	public ResponseEntity<List<Trabajo>> getTrabajosEnviados(@PathVariable("id") Integer id){
		List<Trabajo> trabajos = usuarioService.getTrabajosEnviados(id);
		return new ResponseEntity<List<Trabajo>>(trabajos, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer id){
		Usuario user = usuarioService.getUsuario(id);
		return new ResponseEntity<Usuario>(user, HttpStatus.OK);
	}
}