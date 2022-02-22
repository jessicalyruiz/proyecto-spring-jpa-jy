package ec.edu.uce.modelo.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "cuenta_bamcaria")
public class CuentaBancaria {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "seq_cuba")
	@SequenceGenerator(name = "seq_cuba", sequenceName = "seq_cuba",allocationSize = 1)
	@Column(name = "cuba_id")
	private Integer id;
	
	@Column(name = "cuba_numero")
	private String numero;
	
	@Column(name = "cuba_cliente_cedula")
	private String ClienteCedula;
	
	@Column(name = "cuba_saldo")
	private BigDecimal saldo;
	
	@Column(name = "cuba_tipo")
	private String tipo;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getClienteCedula() {
		return ClienteCedula;
	}

	public void setClienteCedula(String clienteCedula) {
		ClienteCedula = clienteCedula;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
