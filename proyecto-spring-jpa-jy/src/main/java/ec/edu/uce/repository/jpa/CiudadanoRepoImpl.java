package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Ciudadano;

@Repository
@Transactional
public class CiudadanoRepoImpl implements ICiudadanoRepo{

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.entityManager.persist(ciudadano);
	}

	@Override
	public void borrarCiudadanoId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ciudadano buscarCiudadanoId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
