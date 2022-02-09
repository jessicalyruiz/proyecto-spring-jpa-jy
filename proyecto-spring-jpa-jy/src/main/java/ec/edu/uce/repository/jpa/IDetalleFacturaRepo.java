package ec.edu.uce.repository.jpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import ec.edu.uce.modelo.jpa.DetalleFactura;

public interface IDetalleFacturaRepo {

	public List<DetalleFactura> BuscarProductos(BigDecimal valorMin, LocalDate fecha);
}
