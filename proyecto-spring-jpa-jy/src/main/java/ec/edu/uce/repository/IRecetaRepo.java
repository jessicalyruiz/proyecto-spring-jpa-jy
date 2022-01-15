package ec.edu.uce.repository;


import ec.edu.uce.modelo.Receta;

public interface IRecetaRepo {

	public void create(Receta receta);
	public Receta read(Integer id); 
	public void update(Receta receta); 
	public void delete(Integer id); 
}
