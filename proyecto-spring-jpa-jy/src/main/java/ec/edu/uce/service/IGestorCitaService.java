package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;

public interface IGestorCitaService {

	public void registrarNuevaConsulta(Paciente paciente, Receta receta) ; //registra el paciente y la receta
}
