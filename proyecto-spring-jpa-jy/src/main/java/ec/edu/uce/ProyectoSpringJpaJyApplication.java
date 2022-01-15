package ec.edu.uce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoSpringJpaJyApplication implements CommandLineRunner {

	@Autowired
	private IPacienteService pacienteService ;
	
	@Autowired
	private IGestorCitaService gestorCita;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaJyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Paciente paciente1=new Paciente();
		paciente1.setId(6);
		paciente1.setApellido("vi");
		paciente1.setNombre("Andres");
		paciente1.setEdad(27);
		//pacienteService.insertarPaciente(paciente1);
		
//		Paciente paciente2=new Paciente();
//		paciente2.setId(3);
//		paciente2.setApellido("Yan");
//		paciente2.setNombre("Jessi");
//		paciente2.setEdad(27);
//		pacienteService.insertarPaciente(paciente2);
//		
		//pacienteService.borrarPacienteId(2);
		//pacienteService.actualizarPaciente(paciente1);
//		Paciente pac=pacienteService.buscarPacienteId(1);
//		System.out.println(pac.toString());
		Receta receta=new Receta();
		receta.setId(1);
		receta.setIndicaciones("tmar cada 12 horas");
		receta.setMedicamentos("paracetamol");
		
		this.gestorCita.registrarNuevaConsulta(paciente1, receta);
	}

}
