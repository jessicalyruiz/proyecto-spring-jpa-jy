package ec.edu.uce.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.repository.ICuentaBancariaRepo;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	@Autowired
	ICuentaBancariaRepo cuentaRepo;
	
	@Override
	public void create(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.create(cuentaBancaria);
	}

	@Override
	public CuentaBancaria read(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(CuentaBancaria cuentaBancaria) {
		// TODO Auto-generated method stub
		this.cuentaRepo.update(cuentaBancaria);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CuentaBancaria buscarCuentaNumero(String numero) {
		// TODO Auto-generated method stub
		return this.cuentaRepo.buscarCuentaNumero(numero);
	}

	@Override
	@Transactional
	public void realizarTranferencia(String cuantaOrigen, String cuentaDestino, BigDecimal valorTranferir) {
		// TODO Auto-generated method stub
		CuentaBancaria cuentaO=this.buscarCuentaNumero(cuantaOrigen);
		CuentaBancaria cuentaD=this.buscarCuentaNumero(cuentaDestino);
		
		BigDecimal nuevoSaldoOrigen=cuentaO.getSaldo().subtract(valorTranferir);
		cuentaD.setTipo(null);
		
		cuentaO.setSaldo(nuevoSaldoOrigen);
		
		cuentaD.setSaldo(cuentaD.getSaldo().add(valorTranferir));
		
		this.cuentaRepo.update(cuentaD);
		this.cuentaRepo.update(cuentaO);
		
	}

}
