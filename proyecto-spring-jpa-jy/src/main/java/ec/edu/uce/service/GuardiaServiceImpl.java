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
		this.guardiaRepo.borrarGuardiaId(id);
		
	}

	@Override
	public void actualizarGuardia(Guardia guardia) {
		// TODO Auto-generated method stub
		guardiaRepo.actualizarGuardia(guardia);
	}

	@Override
	public Guardia buscarGuardiaId(Integer id) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaId(id);
	}

	@Override
	public Guardia buscarGuardiaApellido(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellido(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoLista(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoLista(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoType(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoType(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoNamed(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoNamed(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoNamedNative(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoNamedNative(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPI(String apellido) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoCreiteriaAPI(apellido);
	}

	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPIand(String apellido, String edificio) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoCreiteriaAPIand(apellido, edificio);
	}

	@Override
	public Guardia buscarGuardiaApellidoCreiteriaAPIor(String apellido, String edificio) {
		// TODO Auto-generated method stub
		return this.guardiaRepo.buscarGuardiaApellidoCreiteriaAPIor(apellido, edificio);
	}

}
