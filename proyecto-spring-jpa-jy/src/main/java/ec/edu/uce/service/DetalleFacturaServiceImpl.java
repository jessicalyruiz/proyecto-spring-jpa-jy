package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.repository.jpa.IDetalleFacturaRepo;

@Service
public class DetalleFacturaServiceImpl implements IDetalleFacturaService{

	@Autowired
	private IDetalleFacturaRepo detalleRepo;
	
	@Override
	public List<DetalleFactura> BuscarProductos(BigDecimal valorMin, LocalDate fecha) {
		// TODO Auto-generated method stub
		return this.detalleRepo.BuscarProductos(valorMin,fecha);
	}



}
