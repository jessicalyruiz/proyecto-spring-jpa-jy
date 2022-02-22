package ec.edu.uce.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


import ec.edu.uce.modelo.jpa.CuentaBancaria;

@Repository
@Transactional
public class CuentaBancariaRepoImpl implements ICuentaBancariaRepo{

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
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.entityManager.merge(cuentaBancaria);
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

}
