package ec.edu.uce.service;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaService {

	public void guardarGuardia(Guardia guardia);
	public void borrarGuardiaId(Integer id);
	public void actualizarGuardia(Guardia guardia);
	public Guardia buscarGuardiaId(Integer id);
	public Guardia buscarGuardiaApellido(String apellido);
}
