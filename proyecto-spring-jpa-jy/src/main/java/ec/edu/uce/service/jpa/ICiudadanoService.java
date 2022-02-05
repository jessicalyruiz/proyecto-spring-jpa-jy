package ec.edu.uce.service.jpa;

import ec.edu.uce.modelo.jpa.Ciudadano;

public interface ICiudadanoService {

	public void guardarCiudadano(Ciudadano ciudadano);
	public void borrarCiudadanoId(Integer id);
	public void actualizarCiudadano(Ciudadano ciudadano);
	public Ciudadano buscarCiudadanoId(Integer id);
}
