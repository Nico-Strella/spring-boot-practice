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

//	@Override
//	public List<Trabajo> findAllTrabajosEnInvestigacionEnviados(Integer usuario_id) {
//		String sql = "SELECT DISTINCT(t.id ),t.* "
//				+ "FROM trabajo t "
//				+ "JOIN autor_trabajo sat ON (t.id = sat.trabajo_id AND sat.autor_id = ?1) "
//				+ "LEFT JOIN evaluador_trabajo et on (et.trabajo_id = t.id) "
//				+ "LEFT JOIN evaluador_trabajoPendiente etp ON (etp.trabajoPendiente_id = t.id)";
//		return (List<Trabajo>) entityManager.createNativeQuery(sql).setParameter(1, usuario_id).getResultList();
//	}

	@Override
	public List<Trabajo> findAllTrabajosEnInvestigacionEnviados(Integer id){
		Usuario user = entityManager.find(Usuario.class, id);

		if(user == null) {
			entityManager.close();
			throw new IllegalArgumentException("el autor no existe");
		}
		
		Query query = entityManager.createNativeQuery("SELECT DISTINCT(t.id ),t.* from trabajo t "
				+ "join autor_trabajo sat on (t.id = sat.trabajo_id and sat.autor_id = :id) "
				+ "left join evaluador_trabajo et on (et.trabajo_id = t.id) "
				+ "left join evaluador_trabajoPendiente etp on (etp.trabajoPendiente_id = t.id)",Trabajo.class);

		query.setParameter("id", id);
		List<Trabajo> trabajos = query.getResultList();
		entityManager.close();
		return trabajos;	

	}
}
