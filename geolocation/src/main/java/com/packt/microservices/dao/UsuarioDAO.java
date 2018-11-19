package com.packt.microservices.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.packt.microservices.entity.Usuario;
import com.packt.microservices.entity.Trabajo;

@Transactional
@Repository
public class UsuarioDAO implements IUsuarioDAO{

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Trabajo> findAllTrabajosEnInvestigacionEnviados(Integer id){
		Usuario user = this.finbById(id);

		if(user == null) {
			throw new IllegalArgumentException("el autor no existe");
		}
		
		Query query = entityManager.createNativeQuery("SELECT DISTINCT(t.id ),t.* from trabajo t "
				+ "join autor_trabajo sat on (t.id = sat.trabajo_id and sat.autor_id = :id) "
				+ "left join evaluador_trabajo et on (et.trabajo_id = t.id) "
				+ "left join evaluador_trabajo_pendiente etp on (etp.trabajo_pendiente_id = t.id)",Trabajo.class);

		query.setParameter("id", id);
		return (List<Trabajo>) query.getResultList();

	}

	@Override
	public Usuario finbById(Integer usuario_id) {
		return entityManager.find(Usuario.class, usuario_id);
	}
}
