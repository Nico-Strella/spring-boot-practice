package com.packt.microservices.usuario;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	@Query(
		value="SELECT DISTINCT(t.id ),t.* "
			+ "FROM trabajo t "
			+ "JOIN autor_trabajo sat ON (t.id = sat.trabajo_id AND sat.autor_id = :id) "
			+ "LEFT JOIN evaluador_trabajo et on (et.trabajo_id = t.id) "
			+ "LEFT JOIN evaluador_trabajoPendiente etp ON (etp.trabajoPendiente_id = t.id)",
		nativeQuery = true
	)
	public List<Trabajo> findAllTrabajosEnInvestigacionEnviados(@Param("id") Integer id);
}