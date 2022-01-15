package ec.edu.uce.service;

import ec.edu.uce.modelo.Paciente;

public interface IPacienteService {
	public void insertarPaciente(Paciente paciente);
	public void borrarPacienteId(Integer id);
	public void actualizarPaciente(Paciente paciente);
	public Paciente buscarPacienteId(Integer id);
}
