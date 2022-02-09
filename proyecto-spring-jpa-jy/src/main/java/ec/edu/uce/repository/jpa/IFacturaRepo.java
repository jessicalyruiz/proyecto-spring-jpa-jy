package ec.edu.uce.repository.jpa;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencillaTO;


public interface IFacturaRepo {

	public void guardarFactura(Factura factura);
	
	public List<Factura> buscarPorFechaJOIN(LocalDate fecha);
	public List<Factura> buscarPorFechaJOINLeft(LocalDate fecha);
	
	public List<Factura> buscarPorFechaJOINWhere(LocalDate fecha);
	
	public List<Factura> buscarPorFechaJOINfetch(LocalDate fecha);
	
	public List<FacturaSencillaTO> buscarPorFechaSencilla(LocalDate fecha);
//	public void borrarFacturaId(Integer id);
//	public void actualizarFactura(Factura factura);
//	public Factura buscarFacturaId(Integer id);
	
}
