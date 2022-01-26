package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Guardia;

public interface IGuardiaRepo {

	public void guardarGuardia(Guardia guardia);
	public void borrarGuardiaId(Integer id);
	public void actualizarGuardia(Guardia guardia);
	public Guardia buscarGuardiaId(Integer id);
	public Guardia buscarGuardiaApellido(String apellido);
	public Guardia buscarGuardiaApellidoLista(String apellido);
	public Guardia buscarGuardiaApellidoType(String apellido);
	public Guardia buscarGuardiaApellidoNamed(String apellido);
	public Guardia buscarGuardiaApellidoNamedNative(String apellido);
	public Guardia buscarGuardiaApellidoCreiteriaAPI(String apellido);
	public Guardia buscarGuardiaApellidoCreiteriaAPIand(String apellido, String edificio);
	public Guardia buscarGuardiaApellidoCreiteriaAPIor(String apellido, String edificio);
}
