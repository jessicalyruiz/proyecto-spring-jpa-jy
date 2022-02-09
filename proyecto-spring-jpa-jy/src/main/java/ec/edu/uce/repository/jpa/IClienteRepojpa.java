package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Cliente;

public interface IClienteRepojpa {

	public void create(Cliente cliente);
	public Cliente read(Integer id); 
	public void update(Cliente cliente); 
	public void delete(Integer id); 
	public Cliente buscarApellido(String apellido); 
	public Cliente buscarApellidoNamed(String apellido); 
	public Cliente buscarApellidoTyped(String apellido); 
}
