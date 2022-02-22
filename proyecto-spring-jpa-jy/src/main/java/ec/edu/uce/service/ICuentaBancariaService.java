package ec.edu.uce.service;

import java.math.BigDecimal;

import ec.edu.uce.modelo.jpa.CuentaBancaria;

public interface ICuentaBancariaService {

	public void create(CuentaBancaria cuentaBancaria);
	public CuentaBancaria read(Integer id); 
	public void update(CuentaBancaria cuentaBancaria); 
	public void delete(Integer id); 
	
	public CuentaBancaria buscarCuentaNumero(String numero);
	
	public void realizarTranferencia(String cuantaOrigen,String cuentaDestino, BigDecimal valorTranferir );
}