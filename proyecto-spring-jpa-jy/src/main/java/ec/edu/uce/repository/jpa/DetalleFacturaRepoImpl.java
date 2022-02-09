package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Factura;

@Repository
@Transactional
public class DetalleFacturaRepoImpl implements IDetalleFacturaRepo {

private static final Logger LOG= (Logger) LoggerFactory.getLogger(FacturaRepoImpl.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<DetalleFactura> BuscarProductos(BigDecimal valorMin, LocalDate fecha) {
		
		TypedQuery<DetalleFactura> myQuery= this.entityManager.createQuery("SELECT d FROM DetalleFactura d JOIN FETCH d.factura f WHERE d.precio>=:valorMin AND f.fecha<=:fecha", DetalleFactura.class);
		myQuery.setParameter("valorMin", valorMin);
		myQuery.setParameter("fecha", fecha);
		
		return myQuery.getResultList();
	}

}
