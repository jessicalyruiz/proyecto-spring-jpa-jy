package ec.edu.uce;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;

@SpringBootApplication
public class ProyectoSpringJpaJyApplication implements CommandLineRunner {
	private static final Logger LOG= (Logger) LoggerFactory.getLogger(ProyectoSpringJpaJyApplication.class);
	
	@Autowired
	private IPacienteService pacienteService ;
	
	@Autowired
	private IGestorCitaService gestorCita;
	
	@Autowired
	private IGuardiaService guardiaService;
	
	@Autowired
	private IFacturaService facturaService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProyectoSpringJpaJyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Paciente paciente1=new Paciente();
//		paciente1.setId(6);
//		paciente1.setApellido("vi");
//		paciente1.setNombre("Andres");
//		paciente1.setEdad(27);
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
//		Receta receta=new Receta();
//		receta.setId(1);
//		receta.setIndicaciones("tmar cada 12 horas");
//		receta.setMedicamentos("paracetamol");
//		
//		this.gestorCita.registrarNuevaConsulta(paciente1, receta);
		
		Guardia guardia=new Guardia();
		guardia.setNombre("alex");
		guardia.setApellido("onz");
		guardia.setEdificio("la carolina");
		guardiaService.guardarGuardia(guardia);
		guardiaService.actualizarGuardia(guardia);
		
		Guardia guardia2=guardiaService.buscarGuardiaId(3);
		System.out.println(guardia2.toString());
		//guardiaService.borrarGuardiaId(5);
		
		//Guardia guardiaApellido=guardiaService.buscarGuardiaApellido("alo2");
		System.out.println(guardiaService.buscarGuardiaApellidoLista("perales").toString());
		
		Guardia guardiaTyped=guardiaService.buscarGuardiaApellidoType("gonz");
		System.out.println(guardiaTyped.toString());
		
		
		Guardia guardiaNamed=guardiaService.buscarGuardiaApellidoType("gonz");
		LOG.info(guardiaNamed.toString());
		//comentario para el branch
		
		
		//***********************
		
		Factura factura=new Factura();
		factura.setCedula("2300115066");
		factura.setFecha(LocalDate.now());
		factura.setNumero("545-78-3");
		//lista de dettalles
		List<DetalleFactura> detalles=new ArrayList<>();
		
		DetalleFactura detalle1=new DetalleFactura();
		detalle1.setCantidad(2);
		detalle1.setPrecio(new BigDecimal(45.8));
		detalle1.setFactura(factura);
		
		
		DetalleFactura detalle2=new DetalleFactura();
		detalle2.setCantidad(2);
		detalle2.setPrecio(new BigDecimal(78.4));
		detalle2.setFactura(factura);
		
		
		detalles.add(detalle1);
		detalles.add(detalle2);
		factura.setDetalles(detalles);
		this.facturaService.guardarFactura(factura);
		
		Factura factura2=new Factura();
		List<Factura> listaFactura=new ArrayList<>();
		
		listaFactura=this.facturaService.buscarPorFechaJOIN(LocalDate.now());
		//listaFactura.forEach(System.out::println);
		/*
		for(int i=0;i<listaFactura.size();i++){
		    System.out.println(listaFactura.get(i));
		}*/
		LOG.info("Longitud"+listaFactura.size());
		for(Factura f: listaFactura) {
			LOG.info(f.toString());
		}
		
		List<Factura> listaFacturaLeft=new ArrayList<>();
		
		listaFacturaLeft=this.facturaService.buscarPorFechaJOINLeft(LocalDate.now());
		
			List<Factura> listaFacturawhere=new ArrayList<>();
		
			listaFacturawhere=this.facturaService.buscarPorFechaJOINLeft(LocalDate.now());
		LOG.info("*****************where**********Longitud"+listaFacturawhere.size());
		for(Factura f: listaFacturawhere) {
			LOG.info(f.toString());
		}
		
		
		
		
	}

}
