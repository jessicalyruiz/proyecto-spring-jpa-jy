package ec.edu.uce.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ec.edu.uce.modelo.jpa.Cliente;



@Repository
@Transactional
public class ClienteRepojpaImpl implements IClienteRepojpa {

	@PersistenceContext
	private EntityManager  entityManager;
	
	@Override
	public void create(Cliente cliente) {
		this.entityManager.persist(cliente);
	}

	@Override
	public Cliente read(Integer id) {
		return this.entityManager.find(Cliente.class, id); 
	}

	@Override
	public void update(Cliente cliente) {
		this.entityManager.merge(cliente);
	}

	@Override
	public void delete(Integer id) {
		Cliente clienteBorrar=this.read(id);
		this.entityManager.remove(clienteBorrar);
		}

	@Override
	public Cliente buscarApellido(String apellido) {
		Query miQuery=this.entityManager.createQuery("select c from Cliente c where c.apellido=:valor");
		miQuery.setParameter("valor", apellido);
		Cliente cliente=(Cliente) miQuery.getSingleResult();
		return cliente;
	}

	@Override
	public Cliente buscarApellidoNamed(String apellido) {
		Query query=this.entityManager.createNamedQuery("Cliente.buscarApellidoNamed");
		query.setParameter("valor", apellido);
		Cliente cliente=(Cliente) query.getSingleResult();
		return cliente;
	}

	@Override
	public Cliente buscarApellidoTyped(String apellido) {
		TypedQuery<Cliente> query=(TypedQuery<Cliente>) this.entityManager.createQuery("select c from Cliente c where c.apellido=:valor");
		query.setParameter("valor", apellido);
		return query.getSingleResult();
	}

}
