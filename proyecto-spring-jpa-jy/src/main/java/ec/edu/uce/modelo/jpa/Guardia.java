package ec.edu.uce.modelo.jpa;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "guardia")
@NamedQueries({
	@NamedQuery(name = "Guardia.buscarApellido", query = "select g from Guardia g where g.apellido=:valor"),
	@NamedQuery(name = "Guardia.buscarApellido2", query = "select g from Guardia g where g.apellido=:valor"),
	@NamedQuery(name = "Guardia.buscarApellido3", query = "select g from Guardia g where g.apellido=:valor")})
@NamedNativeQuery(name = "Guardia.buscarApellidoNative", query ="select * from guardia g where g.apellido=:valor" )
public class Guardia {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_guardia")
	@SequenceGenerator(name = "seq_guardia", sequenceName = "seq_guardia",allocationSize = 1 )
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "name")
	private String nombre;
	
	@Column(name = "apellido")
	private String apellido;
	
	@Column(name = "edificio")
	private String edificio;
	
	//getters y setters
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
	public String getEdificio() {
		return edificio;
	}
	public void setEdificio(String edificio) {
		this.edificio = edificio;
	}
	@Override
	public String toString() {
		return "Guardia [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	
	
	
	
	
}
