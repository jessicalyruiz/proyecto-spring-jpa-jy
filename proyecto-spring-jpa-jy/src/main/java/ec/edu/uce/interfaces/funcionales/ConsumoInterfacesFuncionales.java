package ec.edu.uce.interfaces.funcionales;

public class ConsumoInterfacesFuncionales {

	//metodos high order: metodos que reciben una funcion o comportamiento
	//o high order functions
	public String consumirSupplier(IPersonaSupplier<String> funcion) {
		return funcion.get();
	}
	public void consumirConsumer(IPersonaConsumer<Integer> funcion, Integer valor) {
		funcion.accept(Integer.valueOf(valor));
	}
	
	public boolean consumirPredicate(IPersonaPredicate<String> funcion, String valor) {
		return funcion.evaluar(valor);
		
	}
	
	public Integer consumirFunction(IPersonaFunction<String, Integer> funcion, String cadena)  {
		return funcion.apply(cadena);
	}
	
}
