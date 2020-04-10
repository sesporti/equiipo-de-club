package cuota;

import personal.Socio;

public class CuotaSocio implements Cuota<Socio>{

	private final double CUOTASOCIO = 100.50;
	private Socio tipo;

	public CuotaSocio(Socio socio) {
		tipo = socio;
	}
	
	@Override
	public double getCuota(Socio tipo) {
		
		return CUOTASOCIO;
	}

	@Override
	public Socio getTipo() {
		
		return tipo;
	}

	@Override
	public String toString() {
		return "CuotaSocio = " + getCuota(getTipo());
	}
	
	
}