package ec.edu.uce.repository;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaRepo {

	public void create(CuentaBancaria cuentaBancaria);
	public CuentaBancaria read(Integer id); 
	public void update(CuentaBancaria cuentaBancaria); 
	public void delete(Integer id); 
	
	public CuentaBancaria buscarCuentaNumero(String numero);
}
