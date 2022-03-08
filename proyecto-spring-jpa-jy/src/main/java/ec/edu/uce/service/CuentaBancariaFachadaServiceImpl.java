package ec.edu.uce.service;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import ec.edu.uce.ProyectoSpringJpaJyApplication;
@Service
public class CuentaBancariaFachadaServiceImpl {

	private static final Logger LOG= LoggerFactory.getLogger(ProyectoSpringJpaJyApplication.class);
	
	@Autowired
	ICuentaBancariaService cuentaService;
	
	public void realizarTranferenciaExpressInicialNoT(String cuantaOrigen, String cuentaDestino,
			BigDecimal valorTranferir) {
		LOG.info("PRueba 1:"+ TransactionSynchronizationManager.isActualTransactionActive());
		this.cuentaService.realizarTranferenciaExpress(cuantaOrigen, cuentaDestino, valorTranferir);

		}
		
}
