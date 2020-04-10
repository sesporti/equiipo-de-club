package personal;

import cuota.Cuota;
import cuota.CuotaSocio;

public class Socio extends Persona {
	
	// Aqui yo me hubiera fumado un puro con un int y ya esta 
	private final NumeroSocio numeroSocio;
	private Cuota<Socio> cuota;
	private boolean activo;

	public Socio(String nombre, String sexo, String dni, int edad) {
		super(nombre, sexo, dni, edad);
		numeroSocio = new NumeroSocio();
		cuota = new CuotaSocio(this);
		activo = true;
	}

	public NumeroSocio getNumeroSocio() {
		return numeroSocio;
	}

	public Cuota<Socio> getCuota() {
		return cuota;
	}

	public boolean isActivo() {
		return activo;
	}

	protected void setActivo(boolean activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return super.toString() + ", numeroSocio = " + getNumeroSocio() + ", cuota = " + getCuota() + ", en activo = " + isActivo();
	}

	
}
