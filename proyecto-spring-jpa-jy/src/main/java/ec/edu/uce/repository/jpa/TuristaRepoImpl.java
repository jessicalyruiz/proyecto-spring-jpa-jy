package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.Turista;

@Repository
@Transactional
public class TuristaRepoImpl implements ITuristaRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void create(Turista turista) {
		// TODO Auto-generated method stub
		this.entityManager.persist(turista);
	}

	@Override
	public Turista read(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Turista.class, id);
	}

	@Override
	public void update(Turista turista) {
		// TODO Auto-generated method stub
		this.entityManager.merge(turista);	
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
		Turista turisBorrar=this.read(id);
		this.entityManager.remove(turisBorrar);
	}

	@Override
	public List<Turista> obtenerTodosTuristas() {
		Query myQuiery = this.entityManager.createQuery("Select t from Turista t");
		
		return myQuiery.getResultList();
	}
}
