package ec.edu.uce.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import ec.edu.uce.modelo.jpa.Factura;

public interface IFacturaService {

	public void guardarFactura(Factura factura);
	
	public List<Factura> buscarPorFechaJOIN(LocalDate fecha);
	public List<Factura> buscarPorFechaJOINLeft(LocalDate fecha);
	public List<Factura> buscarPorFechaJOINWhere(LocalDate fecha);
//	public void borrarFacturaId(Integer id);
//	public void actualizarFactura(Factura factura);
//	public Factura buscarFacturaId(Integer id);
}
