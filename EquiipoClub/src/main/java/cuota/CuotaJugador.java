package cuota;

import competicion.Licencia;

public class CuotaJugador implements Cuota<Licencia>{

	private double cuota;
	private Licencia tipo;
	
	public CuotaJugador(Licencia tipo) {
		this.tipo = tipo;
		setCuota(getCuota(tipo));
	}
	
	public double getCuota() {
		return cuota;
	}

	private void setCuota(double cuota) {
		this.cuota = cuota;
	}

	@Override
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
