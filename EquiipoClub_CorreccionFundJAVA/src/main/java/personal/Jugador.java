package personal;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import competicion.Equipo;
import competicion.Licencia;
import competicion.LicenciablePersonal;
import cuota.Cuota;
import cuota.CuotaJugador;

public class Jugador extends Persona implements Familiarizable, LicenciablePersonal, Comparable<Jugador>{
	
	private int numeroJugador = 0;
	private Licencia licencia;
	private Date caducidadLicencia;
	private Equipo equipoActual;
	private Cuota<Licencia> cuotaJugador;
	private List<Familiar> familiares;
	
	public Jugador(String nombre, String sexo, String dni, int edad) {
		super(nombre, sexo, dni, edad);
		if (edad < 4) {
			licencia = Licencia.SINLICENCIA;
		}else if (edad > 3 & edad < 7) {
			licencia = Licencia.DEBUTANTE;
		} else if (edad > 6 & edad < 9) {
			licencia = Licencia.PREBENJAMIN;
		} else if (edad > 8 & edad < 11) {
			licencia = Licencia.BENJAMIN;
		} else if (edad > 10 & edad < 13) {
			licencia = Licencia.ALEVIN;
		} else if (edad > 12 & edad < 15) {
			licencia = Licencia.INFANTIL;
		} else if (edad > 14 & edad < 17) {
			licencia = Licencia.CADETE;
		} else if (edad > 16 & edad < 19) {
			licencia = Licencia.JUVENIL;
		} else if (edad > 18) {
			licencia = Licencia.AFICIONADO;
		} else {
			licencia = Licencia.PROFESIONAL;
		}
		caducidadLicencia = new Date();
		cuotaJugador = new CuotaJugador(getLicencia());
		familiares = new ArrayList<Familiar>();
	}
	
		
	public int getNumeroJugador() {
		return numeroJugador;
	}

	public void setNumeroJugador(int numeroJugador) {
		this.numeroJugador = numeroJugador;
	}

	@Override
	public Licencia getLicencia() {
		return licencia;
	}

	@Override
	public Date fechaCaducidad() {
		
		return caducidadLicencia;
	}
		
	public Date getCaducidadLicencia() {
		return fechaCaducidad();
	}

	public void setCaducidadLicencia(Date caducidadLicencia) {
		this.caducidadLicencia = caducidadLicencia;
	}

	public Equipo getEquipoActual() {
		return equipoActual;
	}
	public void setEquipo (Equipo equipo) {
		this.equipoActual = equipo;
	}
	
	public Cuota<Licencia> getCuotaJugador() {
		return cuotaJugador;
	}

	@Override
	public List<Familiar> getFamiliares() {
	
		return familiares;
	}
	
	public boolean tieneEquipo() {
		// Esto te peta como sea null asi que no tiene sentido el codig
		// lo que debes poner es getEquipoActual() != null
		return !getEquipoActual().equals(null);
	}
	
	// Por eso mejor guardar la fecha de nacimiento
	public int actualizarEdad() {
		 setEdad(getEdad() + 1);
		return getEdad();
	}
	
	public boolean agregarFamiliar (Familiar familiar) {
		
		return getFamiliares().add(familiar);
	}
	
	public boolean eliminarFamiliar (Familiar familiar) {
		
		return getFamiliares().remove(familiar);
	}

	@Override
	public String toString() {
		return String.format(
				"Jugador: [Datos Identificativos = %s, {Licencia(%s), fecha caducidad: %s}, Equipo Actual = %s, Cuota Jugador = %s,"
				+ " Familiares: %s ]",
				super.toString(), getLicencia(), fechaCaducidad(), getEquipoActual(), getCuotaJugador(), getFamiliares());
	}

	@Override
	public int compareTo(Jugador o) {
		// TODO Auto-generated method stub
		return getNumeroJugador()-o.getNumeroJugador();
	}
	
	


	
}
