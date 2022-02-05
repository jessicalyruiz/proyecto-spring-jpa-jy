package ec.edu.uce.repository.jpa;

import ec.edu.uce.modelo.jpa.Ciudadano;


public interface ICiudadanoRepo {

	public void guardarCiudadano(Ciudadano ciudadano);
	public void borrarCiudadanoId(Integer id);
	public void actualizarCiudadano(Ciudadano ciudadano);
	public Ciudadano buscarCiudadanoId(Integer id);
}
