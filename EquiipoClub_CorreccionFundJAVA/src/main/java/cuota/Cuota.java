package cuota;

// Te falta un CuotaImpl que implemente lo que
// tienes repetido en CuotaJugador y CuotaSocio:
// lo que tiene que ver con tipo. Se quedaria solo
// por implementar cuota
public interface Cuota<T> {
	
	double getCuota (T tipoCuota);
	T getTipo();

}
