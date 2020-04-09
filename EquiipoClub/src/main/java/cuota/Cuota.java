package cuota;

public interface Cuota<T> {
	
	double getCuota (T tipoCuota);
	T getTipo();

}
