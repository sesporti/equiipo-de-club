package cuota;

import competicion.Licencia;

public class CuotaJugador implements Cuota<Licencia>{

	// Para que guardar el valor si depende solo de la Licencia?
	private double cuota;
	private Licencia tipo;
	
	// Dije que el constructor debajo de los accesores
	public CuotaJugador(Licencia tipo) {
		this.tipo = tipo;
		// Esto lo repites al final del metodo getCuota
		setCuota(getCuota(tipo));
	}
	
	public double getCuota() {
		return cuota;
	}

	private void setCuota(double cuota) {
		this.cuota = cuota;
	}

	@Override
	// Esto son magic numbers de manual. Al menos
	// sacalos a una clase con datos que se pueda cambiar facil
	// mejor que hardcodeados en el negocio (esto seria
	// la tipica bean que inyectas luego)
	public double getCuota(Licencia tipo) {
		double cuota = 0;
		switch (tipo) {
		case AFICIONADO:
			cuota = 350.50;
			break;
		case JUVENIL:
			cuota = 250.50;
			break;
		case CADETE:
			cuota = 225;
			break;
		case INFANTIL:
			cuota = 300.50;
			break;
		case ALEVIN:
			cuota = 395.50;
			break;
		case BENJAMIN:
			cuota = 395.50;
			break;
		case PREBENJAMIN:
			cuota = 395.50;
			break;
		case DEBUTANTE:
			cuota = 400;
			break;
		case SINLICENCIA:
			cuota = 100;
			break;
		default:
			break;
		}
		setCuota(cuota);
		return cuota;
	}

	@Override
	public Licencia getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "CuotaJugador = " + getCuota();
	}

	
}
