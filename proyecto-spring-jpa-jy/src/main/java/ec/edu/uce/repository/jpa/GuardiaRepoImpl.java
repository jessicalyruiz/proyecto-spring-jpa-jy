package ec.edu.uce.repository.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.jpa.Guardia;

/**
 * @author Jessirena
 *
 */
/**
 * @author Jessirena
 *
 */
@Repository
@Transactional
public class GuardiaRepoImpl implements IGuardiaRepo{

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(GuardiaRepoImpl.class);
	
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
		Guardia guard=null;
		try {
			Query miQuiery=this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuiery.setParameter("valor", apellido);
		guard=(Guardia) miQuiery.getSingleResult();
		} catch (NoResultException e) {
			LOG.error("No existe un resultado para "+apellido,e);
		}
		
		//List<Guardia> listaGuardia=
		
		return guard;
	}



	@Override
	public Guardia buscarGuardiaApellidoLista(String apellido) {
		
			Query miQuiery=this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		miQuiery.setParameter("valor", apellido);
		List<Guardia> listaGuardia= miQuiery.getResultList();
		if(!listaGuardia.isEmpty()) {
			LOG.info("Existe mas de un resulpado para "+apellido+" Se encontraron: ",listaGuardia.size());
			return listaGuardia.get(0);
		}else {	
		return null;
		}
	}



	/**
	 *Este metodo es igual que el buscarGuardiaApellido nada mas que con TypedQuery
	 */
	@Override
	public Guardia buscarGuardiaApellidoType(String apellido) {
		TypedQuery<Guardia> myTypedQuery=(TypedQuery<Guardia>) this.entityManager.createQuery("select g from Guardia g where g.apellido=:valor");
		myTypedQuery.setParameter("valor", apellido);
		return myTypedQuery.getSingleResult();
	}



	/**
	 *Este metodo es igual que el buscarGuardiaApellido nada mas que con NamedQuery
	 */
	@Override
	public Guardia buscarGuardiaApellidoNamed(String apellido) {
		Query query=this.entityManager.createNamedQuery("Guardia.buscarApellido");
		query.setParameter("valor", apellido);
		Guardia guard=(Guardia) query.getSingleResult();
		return guard;
	}



}
