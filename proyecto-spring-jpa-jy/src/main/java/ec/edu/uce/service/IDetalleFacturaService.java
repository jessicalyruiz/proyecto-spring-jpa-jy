package ec.edu.uce.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleFactura;

public interface IDetalleFacturaService {

	public List<DetalleFactura> BuscarProductos(BigDecimal valorMin,LocalDate fecha);
}
