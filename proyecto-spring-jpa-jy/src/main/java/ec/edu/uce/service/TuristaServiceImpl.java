package ec.edu.uce.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.edu.uce.modelo.Turista;
import ec.edu.uce.repository.jpa.ITuristaRepo;

@Service
public class TuristaServiceImpl implements ITuristaService{

	@Autowired
	private ITuristaRepo turisRepo;

	@Override
	public void create(Turista turista) {
		// TODO Auto-generated method stub
		this.turisRepo.create(turista);
	}

	@Override
	public Turista read(Integer id) {
		// TODO Auto-generated method stub
		return this.turisRepo.read(id);
	}

	@Override
	public void update(Turista turista) {
		// TODO Auto-generated method stub
		this.turisRepo.update(turista);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		this.turisRepo.delete(id);
	}
	
	
	@Override
	public List<Turista> obtenerTodosTuristas() {
		List<Turista> lista=this.turisRepo.obtenerTodosTuristas();//repo
		List<Turista> listaCalculada=this.calcularSaldo(lista);
		return listaCalculada;
	}

	private List<Turista> calcularSaldo(List<Turista> listaTur){
		for (Turista turista : listaTur) {
			BigDecimal saldo= turista.getValor().subtract(turista.getAbono());
			turista.setSaldo(saldo);
		}
		return listaTur;
	}
}
