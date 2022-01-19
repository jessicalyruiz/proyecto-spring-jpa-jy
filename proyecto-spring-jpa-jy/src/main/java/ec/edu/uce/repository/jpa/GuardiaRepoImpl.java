package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Guardia;

@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo{

	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public void guardarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.persist(guardia);
	}

	

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		this.entityManager.merge(guardia);
	}

	@Override
	public Guardia buscarGuardiaId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Guardia.class, id);
	}

	@Override
	public void borrarGuardiaId(Integer id) {
		Guardia guardiaABorrar=this.buscarGuardiaId(id);
		this.entityManager.remove(guardiaABorrar);
	}



	@Override
	public Guardia buscarGuardiaApellido(String apellido) {
		// SQL normal:  select * from guardia where apellid=''
		//JPQL			select g from Guardia g where a.apellido=:valor
		Query miQuiery=this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuiery.setParameter("valor", apellido);
		Guardia guard=(Guardia) miQuiery.getSingleResult();
		return guard;
	}



}
