package ec.edu.uce.interfaces.funcionales;

public class MainMetodosReferenciados {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1 Implemetar por clases
		IPersonaSupplier<String> persona=new PersonaSupplierImpl();
		String mensaje=persona.get();
		System.out.println(mensaje);
		
		//2 implementar por lambdas
		IPersonaSupplier<String> persona1=()->"Se implemeta";
		String mensaje1=persona1.get();
		System.out.println(mensaje1);
		
		//3. Metodos Referenciados
		PersonaSupplierImpl personaImpl=new PersonaSupplierImpl();
		IPersonaSupplier<String> persona2=personaImpl::get;
		String mensaje2=persona2.get();
		System.out.println(mensaje2);
		
		//3.1
		PersonaSupplierSinImpl personaSinImpl=new PersonaSupplierSinImpl();
		IPersonaSupplier<String> persona3=personaSinImpl::get;
		String mensaje3=persona3.get();
		System.out.println(mensaje3);
		
		//3.2
		PersonaPredicateImpl personaPre=new PersonaPredicateImpl();
		IPersonaPredicate<String> personaPredi2=personaPre::evaluar;
		Boolean valor=personaPredi2.evaluar("mensaje");
		System.out.println(prueba(personaPre::evaluar));
	}
	
	public static boolean prueba(IPersonaPredicate<String> arg) {
		return arg.evaluar("mensaje metodo");
	}

}
