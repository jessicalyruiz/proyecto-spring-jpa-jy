package ec.edu.uce.repository.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import ec.edu.uce.ProyectoSpringJpaJyApplication;
import ec.edu.uce.modelo.jpa.Factura;

@Repository
@Transactional
public class FacturaRepoImpl implements IFacturaRepo {

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(ProyectoSpringJpaJyApplication.class);
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.entityManager.persist(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOIN(LocalDate fecha) {
		TypedQuery<Factura> myQuery= this.entityManager.createQuery("SELECT f FROM Factura f JOIN f.detalles d WHERE f.fecha<=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		List<Factura> listaFactura=myQuery.getResultList();
		LOG.info("Longitud REpo "+listaFactura.size());
		for(Factura f: listaFactura) {
			LOG.info("detalles "+f.getDetalles());
			LOG.info(f.toString());
		}
		
		
		return listaFactura;
	}

	@Override
	public List<Factura> buscarPorFechaJOINLeft(LocalDate fecha) {
		TypedQuery<Factura> myQuery= this.entityManager.createQuery("SELECT f FROM Factura f LEFT JOIN f.detalles d WHERE f.fecha<=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		//para recuperar los detalles
		
		List<Factura> listaFactura=myQuery.getResultList();
		LOG.info("Longitud REpo "+listaFactura.size());
		for(Factura f: listaFactura) {
			LOG.info("detalles "+f.getDetalles());
			LOG.info(f.toString());
		}
		
		
		return listaFactura;
	}

	@Override
	public List<Factura> buscarPorFechaJOINWhere(LocalDate fecha) {
		TypedQuery<Factura> myQuery= this.entityManager.createQuery("SELECT f FROM Factura f, DetalleFactura d  WHERE f=d.factura AND f.fecha<=:fecha", Factura.class);
		myQuery.setParameter("fecha", fecha);
		//para recuperar los detalles bajo demanda
		
				List<Factura> listaFactura=myQuery.getResultList();
				LOG.info("Longitud REpo "+listaFactura.size());
				for(Factura f: listaFactura) {
					LOG.info("detalles "+f.getDetalles());
					LOG.info(f.toString());
				}
				
				
				return listaFactura;
	}
	
	

}
