package ec.edu.uce.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.ProyectoSpringJpaJyApplication;
import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.repository.ICuentaBancariaRepo;
@Service
public class CuentaBancariaServiceImpl implements ICuentaBancariaService {

	private static final Logger LOG= (Logger) LoggerFactory.getLogger(ProyectoSpringJpaJyApplication.class);
	
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
		//cuentaD.setTipo(null);
		
		cuentaO.setSaldo(nuevoSaldoOrigen);
		
		cuentaD.setSaldo(cuentaD.getSaldo().add(valorTranferir));
		LOG.info("AA1");
		this.cuentaRepo.update(cuentaD);
		LOG.info("DA1");
		LOG.info("AA2");
		try {
		this.cuentaRepo.actualizar(cuentaO);
		}catch (ArrayIndexOutOfBoundsException e) {
			LOG.error("Error");
		}
		LOG.info("DA2");
		
	}

}
