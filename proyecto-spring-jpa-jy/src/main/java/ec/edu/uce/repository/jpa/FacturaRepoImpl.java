package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Factura;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

}
