package ec.edu.uce.interfaces.funcionales;

@FunctionalInterface
public interface IPersonaPredicate<T> {
	public boolean evaluar(T arg);
}
