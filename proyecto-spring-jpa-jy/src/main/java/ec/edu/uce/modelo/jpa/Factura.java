package ec.edu.uce.modelo.jpa;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	

	@Id
	@Column(name = "fact_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_factura")
	@SequenceGenerator(name = "seq_factura", sequenceName = "seq_factura",allocationSize = 1 )
	private Integer id;
	
	@Column(name = "fact_cedula")
	private String cedula;
	
	@Column(name = "fact_numero")
	private String numero;
	
	@Column(name = "fact_fecha", columnDefinition = "TIMESTAMP")//TIMESTAMP PARA FECHA Y HORA
	private LocalDate fecha;//no usar date pues esta deprecado

	//una factura puede tener muchos detalles
	@OneToMany(mappedBy = "factura", cascade = CascadeType.ALL)//se dispara en cascada las inserciones *****, fetch = FetchType.EAGER
	private List<DetalleFactura> detalles;
	
	
	//GETTERS Y SETTERS
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<DetalleFactura> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	
	@Override
	public String toString() {
		return "Factura [id=" + id + ", cedula=" + cedula + ", numero=" + numero + ", fecha=" + fecha + ", detalles="
				+ detalles + "]";
	}
}
