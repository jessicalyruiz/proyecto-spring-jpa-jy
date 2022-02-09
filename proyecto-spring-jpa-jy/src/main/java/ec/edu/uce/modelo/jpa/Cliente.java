package ec.edu.uce.modelo.jpa;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cliente_clase")
public class Cliente {

	@Id
	@Column(name = "clie_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura",allocationSize = 1 )
	private Integer id;
	
	@Column(name ="clie_nombre" )
	private String nombre;

	@ElementCollection //crea un tabla ligera relacionada a cliente con un unico dato
	private List<String> telefonos;
	
	
	//get y set
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

	public List<String> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<String> telefonos) {
		this.telefonos = telefonos;
	}
	
	
}
