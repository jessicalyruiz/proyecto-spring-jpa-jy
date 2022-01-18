package ec.edu.uce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;

@Service
public class GuardiaServiceImpl implements IGuardiaService{

	@Autowired
	private GuardiaRepoImpl guardiaRepo;
	
	@Override
	public void guardarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		guardiaRepo.guardarGuardia(guardia);
	}

	@Override
	public void borrarGuardiaId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		guardiaRepo.actualizarGuardia(guardia);
	}

	@Override
	public Guardia buscarGuardiaId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
