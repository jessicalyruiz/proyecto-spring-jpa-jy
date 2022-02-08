package ec.edu.uce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.repository.jpa.IFacturaRepo;

@Service
public class FacturaServiceImpl implements IFacturaService{

	@Autowired
	private IFacturaRepo facturaRepo;
	
	@Override
	public void guardarFactura(Factura factura) {
		// TODO Auto-generated method stub
		this.facturaRepo.guardarFactura(factura);
	}

	@Override
	public List<Factura> buscarPorFechaJOIN(LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaJOIN(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINLeft(LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaJOINLeft(fecha);
	}

	@Override
	public List<Factura> buscarPorFechaJOINWhere(LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.facturaRepo.buscarPorFechaJOINWhere(fecha);
	}

}
