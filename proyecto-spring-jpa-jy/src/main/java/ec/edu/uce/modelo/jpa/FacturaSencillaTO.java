package ec.edu.uce.modelo.jpa;

public class FacturaSencillaTO {

	private String numero;
	private String cedula;
	//es mandatiorio que se cree un contructor con los atributods
	
	public FacturaSencillaTO() {
		
	}
	
	public FacturaSencillaTO(String numero, String cedula) {
		super();
		this.numero = numero;
		this.cedula = cedula;
	}
	
	//SET Y GET
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
}
