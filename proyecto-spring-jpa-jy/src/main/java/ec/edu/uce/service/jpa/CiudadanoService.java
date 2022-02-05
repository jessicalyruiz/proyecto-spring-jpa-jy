package ec.edu.uce.service.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.jpa.Ciudadano;
import ec.edu.uce.repository.jpa.ICiudadanoRepo;


@Service
public class CiudadanoService implements ICiudadanoService{

	@Autowired
	private ICiudadanoRepo ciudadanoRepo;
	
	@Override
	public void guardarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		this.ciudadanoRepo.guardarCiudadano(ciudadano);
	}

	@Override
	public void borrarCiudadanoId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCiudadano(Ciudadano ciudadano) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ciudadano buscarCiudadanoId(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
