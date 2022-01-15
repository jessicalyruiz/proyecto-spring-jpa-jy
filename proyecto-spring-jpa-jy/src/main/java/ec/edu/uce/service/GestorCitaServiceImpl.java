package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
@Service
public class GestorCitaServiceImpl implements IGestorCitaService{

	@Autowired
	private IPacienteService pacienteService;
	
	@Autowired
	private IRecetaService recetaService;
	
	@Override
	public void registrarNuevaConsulta(Paciente paciente, Receta receta) {
		// TODO Auto-generated method stub
		this.pacienteService.insertarPaciente(paciente);
		this.recetaService.guardarReceta(receta);
	}

}
