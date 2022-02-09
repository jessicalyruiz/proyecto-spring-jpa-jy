package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Cliente;

public interface IClienteServicejpa {

	public void insertar(Cliente cliente);
	public Cliente buscar(Integer id); 
	public void actualizar(Cliente cliente); 
	public void eliminar(Integer id); 

}
