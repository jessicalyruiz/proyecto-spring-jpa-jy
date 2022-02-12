package ec.edu.uce.service;

import java.util.List;

import ec.edu.uce.modelo.Turista;

public interface ITuristaService {

	public void create(Turista turista);
	public Turista read(Integer id); 
	public void update(Turista turista); 
	public void delete(Integer id); 
	public List<Turista> obtenerTodosTuristas();
}
