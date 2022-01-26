package ec.edu.uce.repository.jpa;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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



	@Override
	public Guardia buscarGuardiaApellidoNamedNative(String apellido) {
		Query query=this.entityManager.createNamedQuery("Guardia.buscarApellidoNative",Guardia.class);
		query.setParameter("valor", apellido);
		Guardia guard=(Guardia) query.getSingleResult();
		return guard;
	}



	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPI(String apellido) {
		CriteriaBuilder miCriteria=this.entityManager.getCriteriaBuilder(); //le digo como va a trabajar
		CriteriaQuery<Guardia>miQuery=miCriteria.createQuery(Guardia.class);//declaro un query
		//aqui empiezo a contruir mi SQL
		Root<Guardia> miTabla=miQuery.from(Guardia.class);
		//empiezo a crear el where que en criteria API se los comoce como predicados
		Predicate p1=miCriteria.equal(miTabla.get("apellido"),apellido);
		
		//empezamos a conformar el select
		miQuery.select(miTabla).where(p1);
		TypedQuery<Guardia> typedQuery=  this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}



	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPIand(String apellido, String edificio) {
		CriteriaBuilder miCriteria=this.entityManager.getCriteriaBuilder(); //le digo como va a trabajar
		CriteriaQuery<Guardia>miQuery=miCriteria.createQuery(Guardia.class);//declaro un query
		//aqui empiezo a contruir mi SQL
		Root<Guardia> miTabla=miQuery.from(Guardia.class);
		//empiezo a crear el where que en criteria API se los comoce como predicados
		//select * from guardia where apellido= '' and edificio=''
		Predicate p1=miCriteria.equal(miTabla.get("apellido"),apellido);
		Predicate p2=miCriteria.equal(miTabla.get("edificio"),edificio);
		Predicate predicadoFinal=miCriteria.and(p1,p2);
		//empezamos a conformar el select
		miQuery.select(miTabla).where(predicadoFinal);
		TypedQuery<Guardia> typedQuery=  this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}



	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPIor(String apellido, String edificio) {
		CriteriaBuilder miCriteria=this.entityManager.getCriteriaBuilder(); //le digo como va a trabajar
		CriteriaQuery<Guardia>miQuery=miCriteria.createQuery(Guardia.class);//declaro un query
		//aqui empiezo a contruir mi SQL
		Root<Guardia> miTabla=miQuery.from(Guardia.class);
		//empiezo a crear el where que en criteria API se los comoce como predicados
		//select * from guardia where apellido= '' and edificio=''
		Predicate p1=miCriteria.equal(miTabla.get("apellido"),apellido);
		Predicate p2=miCriteria.equal(miTabla.get("edificio"),edificio);
		Predicate predicadoFinal=miCriteria.or(p1,p2);
		//empezamos a conformar el select
		miQuery.select(miTabla).where(predicadoFinal);
		TypedQuery<Guardia> typedQuery=  this.entityManager.createQuery(miQuery);
		return typedQuery.getSingleResult();
	}



}
