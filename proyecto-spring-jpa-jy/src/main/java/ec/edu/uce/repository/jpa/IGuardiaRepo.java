package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaRepo {

	public void guardarGuardia(Guardia guardia);
	public void borrarGuardiaId(Integer id);
	public void actualizarGuardia(Guardia guardia);
	public Guardia buscarGuardiaId(Integer id);
	public Guardia buscarGuardiaApellido(String apellido);
}
