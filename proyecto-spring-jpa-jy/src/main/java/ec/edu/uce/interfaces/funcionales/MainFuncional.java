package ec.edu.uce.interfaces.funcionales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Stream;



public class MainFuncional {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IPersonaSupplier<String> supplier=new PersonaSupllier();
		System.out.println(supplier.get());
		
		//a travez de lambdas
		IPersonaSupplier<String> supplier1=()->"hola mundo2";
		//con return   IPersonaSupplier<String> supplier1=()->{return "hola mundo2";};
		System.out.println(supplier1.get());
		
		//implementar otro idioma
		IPersonaSupplier<String> supplier3=new PersonaSupplierFrances();
		System.out.println(supplier3.get());
		IPersonaSupplier<String> supplier4=()->"bonjour le monde2";
		System.out.println(supplier4.get());
		
		ConsumoInterfacesFuncionales consumo=new ConsumoInterfacesFuncionales();
		String resultado=consumo.consumirSupplier(()->"bonjour le monde2!!!");
		System.out.println(resultado);
		
		//Supplier en  java
		Stream<String>test= Stream.generate(()->"stream").limit(10);
			//no supplier	test.forEach(x->System.out.println(x));
		
		//consumer
		System.out.println("***Consumer");
		IPersonaConsumer<Integer> personaConsumer=number->System.out.println(number.intValue()+1);
		personaConsumer.accept(8);
		
		consumo.consumirConsumer(number->System.out.println(number+5), 10);
		//Consumer java
		List<Integer> listaNumeros=Arrays.asList(1,2,4,5,7);
		listaNumeros.forEach(n->System.out.println(n));
		
		//predicate
		System.out.println("***Predicate");
		boolean result=consumo.consumirPredicate(cadena->cadena.contains("e"), "predicate");
		System.out.println(result);
			//predicate java
		Stream<Integer>numFiltrados= listaNumeros.stream().filter(num->num>4);
		numFiltrados.forEach(n->System.out.println(n));
		
		//Function
		System.out.println("***Funtion");
		Integer resultado2=consumo.consumirFunction(cadena->Integer.parseInt(cadena)+2, "4");
		System.out.println(resultado2);
		
		//funtion en java
		Stream<String>listaCambiada= listaNumeros.stream().map(num->num.toString()+"jessi");
		listaCambiada.forEach(c->System.out.println(c));
		
		//unaryOperator
		Optional<Integer> sum= listaNumeros.stream().reduce((a,b)->a+b);
		System.out.println(sum);
		
		
		//mis ejemplos
		System.out.println("*******Mis ejemplos");
		//supplier
		System.out.println("**supplier");
		Supplier<LocalDate> fecha=()->LocalDate.now();
		System.out.println(fecha.get());
		
		//consumer
		
		System.out.println("**consumer");
		Consumer<String> saludoNombre=n->saludo(n);
		saludoNombre.accept("lorena");
		
		//Predicate
		
		System.out.println("**Predicate");
		System.out.println(listaNumeros.stream().anyMatch(n->n==5));//busco si existe un numero en la lista
		
		//Function
		System.out.println("***Funtion");
		List<String> letras=Arrays.asList("casa","carro", "patio");
		Stream<String> letraMayus=letras.stream().map(t -> t.toUpperCase());//convierto a mayusculas
		letraMayus.forEach(n->System.out.println(n));
		
	}

	//metodo void para el consumer
			public static void saludo(String nombre) {
				System.out.println("hola "+ nombre);
			}
}
