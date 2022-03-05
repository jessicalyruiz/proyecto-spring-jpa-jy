package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.ProyectoSpringJpaJyApplication;
import ec.edu.uce.modelo.jpa.CuentaBancaria;

/**
 * @author Jessirena
 *
 */
@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{
	private static final Logger LOG= (Logger) LoggerFactory.getLogger(ProyectoSpringJpaJyApplication.class);
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void create(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.persist(cuentaBancaria);
	}

	@Override
	public CuentaBancaria read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		//throw new ArrayIndexOutOfBoundsException();
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaBancaria buscarCuentaNumero(String numero) {
		TypedQuery<CuentaBancaria> myQuery=this.entityManager.createQuery("SELECT c FROM CuentaBancaria c  WHERE c.numero=:valor", CuentaBancaria.class);
		myQuery.setParameter("valor", numero);
		
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
		//try {
	//	throw new ArrayIndexOutOfBoundsException();
//		}catch (ArrayIndexOutOfBoundsException e) {
//			LOG.error("Error Actualizar");
//	}
	}

	/**
	 *para el scope never
	 */
	@Override
	@Transactional(value = TxType.NEVER)
	public void enviarMail(String asunto) {
		// TODO Auto-generated method stub
		LOG.info("se envia el mail");
	}



}
