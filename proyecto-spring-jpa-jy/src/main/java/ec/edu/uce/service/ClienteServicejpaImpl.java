package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.repository.jpa.IClienteRepojpa;


@Service
public class ClienteServicejpaImpl implements IClienteServicejpa {
	@Autowired
	private IClienteRepojpa clienteRepo;
	
	@Override
	public void insertar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.create(cliente);
	}

	@Override
	public Cliente buscar(Integer id) {
		// TODO Auto-generated method stub
		return clienteRepo.read(id);
	}

	@Override
	public void actualizar(Cliente cliente) {
		// TODO Auto-generated method stub
		clienteRepo.update(cliente);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		clienteRepo.delete(id);
	}


}
