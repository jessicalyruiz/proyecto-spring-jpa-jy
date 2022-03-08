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

import ch.qos.logback.core.net.server.Client;
import ec.edu.uce.modelo.Paciente;
import ec.edu.uce.modelo.Receta;
import ec.edu.uce.modelo.Turista;
import ec.edu.uce.modelo.jpa.Cliente;
import ec.edu.uce.modelo.jpa.CuentaBancaria;
import ec.edu.uce.modelo.jpa.DetalleFactura;
import ec.edu.uce.modelo.jpa.Factura;
import ec.edu.uce.modelo.jpa.FacturaSencillaTO;
import ec.edu.uce.modelo.jpa.Guardia;
import ec.edu.uce.repository.jpa.GuardiaRepoImpl;
import ec.edu.uce.service.CuentaBancariaFachadaServiceImpl;
import ec.edu.uce.service.IClienteServicejpa;
import ec.edu.uce.service.ICuentaBancariaService;
import ec.edu.uce.service.IDetalleFacturaService;
import ec.edu.uce.service.IFacturaService;
import ec.edu.uce.service.IGestorCitaService;
import ec.edu.uce.service.IGuardiaService;
import ec.edu.uce.service.IPacienteService;
import ec.edu.uce.service.ITuristaService;

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
	
	@Autowired
	private IDetalleFacturaService detalleService;
	
	@Autowired
	private IClienteServicejpa clienteService;
	
	@Autowired ITuristaService turisService;
	
	@Autowired
	ICuentaBancariaService cuentaService;
	
	@Autowired CuentaBancariaFachadaServiceImpl cuantaFachada;
	
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
		/*
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
		
		*/
		//***********************
		/*
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
		*/
//		Factura factura2=new Factura();
//		List<Factura> listaFactura=new ArrayList<>();
//		
//		listaFactura=this.facturaService.buscarPorFechaJOIN(LocalDate.now());
		//listaFactura.forEach(System.out::println);
		/*
		for(int i=0;i<listaFactura.size();i++){
		    System.out.println(listaFactura.get(i));
		}*/
		/*
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
		*/
		
//		List<Factura> listaFetch=this.facturaService.buscarPorFechaJOINfetch(LocalDate.now());
//		LOG.info("*****************fetch**********Longitud"+listaFetch.size());
//		for(Factura f: listaFetch) {
//			LOG.info(f.toString());
//			LOG.info("Detalles: " +f.getDetalles());
//		}
		
		/*
		List<DetalleFactura> listaPrecio=this.detalleService.BuscarProductos(new BigDecimal(50), LocalDate.now());
		LOG.info("*****************Precio**********Longitud"+listaPrecio.size());
		for(DetalleFactura d: listaPrecio) {
			LOG.info(d.toString());
			LOG.info("Factura:  "+d.getFactura().getFecha() );
		}	
	
		*/
		
		/*
		Cliente cliente= new Cliente();
		cliente.setNombre("Jessica" );
		List<String> telefonos= new ArrayList<>();
		telefonos.add("4545212");
		telefonos.add("7845452");
		cliente.setTelefonos(telefonos);
		clienteService.insertar(cliente);
		*/
		
		/*
		
		List<FacturaSencillaTO> listaFactura=this.facturaService.buscarPorFechaSencilla(LocalDate.now());
		for (FacturaSencillaTO f : listaFactura) {
			LOG.info(f.toString());
		}
		*/
		
		////////////////modulo 3
		/*
		Turista turista=new Turista();
		turista.setAbono(new BigDecimal(30));
		turista.setNombre("jessi");
		turista.setValor(new BigDecimal(70));
		this.turisService.create(turista);
		
		Turista turista2=new Turista();
		turista2.setAbono(new BigDecimal(20));
		turista2.setNombre("taty");
		turista2.setValor(new BigDecimal(70));
		this.turisService.create(turista2);
		
		Turista turista3=new Turista();
		turista3.setAbono(new BigDecimal(60));
		turista3.setNombre("nancy");
		turista3.setValor(new BigDecimal(70));
		this.turisService.create(turista3);
		
		Turista turista4=new Turista();
		turista4.setAbono(new BigDecimal(40));
		turista4.setNombre("pedro");
		turista4.setValor(new BigDecimal(70));
		this.turisService.create(turista4);
		
		Turista turista5=new Turista();
		turista5.setAbono(new BigDecimal(50));
		turista5.setNombre("andres");
		turista5.setValor(new BigDecimal(70));
		this.turisService.create(turista5);
		*/
//		List<Turista> listaTuristasSaldo=this.turisService.obtenerTodosTuristas();
//		
//		for (Turista turista6 : listaTuristasSaldo) {
//			LOG.info(turista6.toString());
//		}
		
		
		//taller 32
		/*
		CuentaBancaria cuenta=new CuentaBancaria();
		
		cuenta.setClienteCedula("2300");
		cuenta.setNumero("45454");
		cuenta.setSaldo(new BigDecimal(8956565));
		cuenta.setTipo("ahorros");
		cuentaService.create(cuenta);
		
	CuentaBancaria cuenta2=new CuentaBancaria();
		
		cuenta2.setClienteCedula("17063");
		cuenta2.setNumero("363");
		cuenta2.setSaldo(new BigDecimal(505));
		cuenta2.setTipo("ahorros");
		cuentaService.create(cuenta2);
		*/
		
		
		//	cuentaService.realizarTranferencia("363", "45454", new BigDecimal(7070));
		//	cuentaService.realizarTranferencia("45454", "363", new BigDecimal(21210));
			
		//this.cuentaService.propagacionMandatory();
			
			
			//support
		//	cuentaService.realizarTranferenciaExpressInicial("45454", "363", new BigDecimal(70));
		//cuentaService.realizarTranferenciaExpressInicialNoT("45454", "363", new BigDecimal(70));
		
		//never
		//this.cuentaService.enviarMail();
		//this.cuentaService.enviarMailNoT();
		cuantaFachada.realizarTranferenciaExpressInicialNoT("45454", "363", new BigDecimal(70));

	}
	
	
	

}
