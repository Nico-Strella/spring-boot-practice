package com.packt.microservices.dao;

import java.util.List;

import com.packt.microservices.entity.Trabajo;

public interface IUsuarioDAO {
	List<Trabajo> findAllTrabajosEnInvestigacionEnviados(Integer usuario_id);
}
