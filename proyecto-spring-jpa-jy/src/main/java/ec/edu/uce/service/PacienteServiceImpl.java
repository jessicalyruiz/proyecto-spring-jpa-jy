package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.repository.IPacienteRepo;

@Service
public class PacienteServiceImpl implements IPacienteService{

	@Autowired
	private IPacienteRepo pacienteRepo;
	
	@Override
	public void insertarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		this.pacienteRepo.create(paciente);
	}

	@Override
	public void borrarPacienteId(Integer id) {
		// TODO Auto-generated method stub
		this.pacienteRepo.delete(id);
	}

	@Override
	public void actualizarPaciente(Paciente paciente) {
		// TODO Auto-generated method stub
		pacienteRepo.update(paciente);
	}

	@Override
	public Paciente buscarPacienteId(Integer id) {
		// TODO Auto-generated method stub
		return pacienteRepo.read(id);
	}


}
