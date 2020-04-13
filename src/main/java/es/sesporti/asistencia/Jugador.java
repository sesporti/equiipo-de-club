package es.sesporti.asistencia;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;

public class Jugador implements Nombrable, Comparable<Jugador>{

	protected long id;
	private String nombre, nif, poc;
	private LocalDate fechaNacimiento;
	
//	@ManyToOne
	private Equipo equipo;
	
//	@OneToMany//(targetEntity=Asistencia.class)
	private List<Asistencia> asistencias;
	
	//ACCESORS: GETTERS & SETTERS
	@Override
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}

	public String getPoc() {
		return poc;
	}

	public void setPoc(String poc) {
		this.poc = poc;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
	public long getEquipoId() {
		return getEquipo().getId();
	}

	public void setEquipoId(Equipo equipo) {
		this.equipo.id = equipo.id;
	}
	
	public String getEquipoNombre() {
		return getEquipo().getNombre();
	}
	
	public String getEquipoCategoria() {
		return getEquipo().getCategoria();
	}
	
	public String getEquipoLicencia() {
		return getEquipo().getLicencia();
	}

	//CONSTRUCTORS
	public Jugador() {}
	
	public Jugador(long id, String nif, LocalDate fechaNacimiento, Equipo equipo) {
		this(id, "PENDIENTE DEFINICION", nif, "SIN POC, MAYOR DE EDAD", fechaNacimiento, equipo);
	}
	
	public Jugador (long id, String nombre, String nif, String poc, LocalDate fechaNacimiento, Equipo equipo) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setPoc(poc);
		setFechaNacimiento(fechaNacimiento);
		setEquipo(equipo);
		asistencias = new ArrayList<Asistencia>();
	}
	
	//METHODS
	/**
	 * Devuelve la edad actual teniendo en cuenta el campo fechaNacimiento.
	 * @return int
	 */
	public int getEdad() {
		
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(getFechaNacimiento(), ahora);
		
		return periodo.getYears();
	}
	
	/**
	 * Agrega la asistencia al jugador si no existe y actualiza el jugador en la asistencia pasada como parametro.
	 * @param asistencia (si no existe el jugador en la asistencia lo añade)
	 */
	public void addAsistencia(Asistencia asistencia) {
        if (!getAsistencias().contains(asistencia)) {
        	getAsistencias().add(asistencia);
            if (asistencia.getJugador() != this) {
                asistencia.setJugador(this);
            }
		}		
    }
	
	@Override
	public String toString() {
		return String.format("Jugador (%s): Nombre: %s, NIF (%s), edad: %s, Persona de Contacto: %s, Equipo: %s ",
							getId(), getNombre(), getNif(), getEdad(), getPoc(), getEquipoNombre());				
	}

	@Override
	public int compareTo(Jugador o) {
		
		if (this.getNombre().equals(o.getNombre())) {
			return this.getEdad() - o.getEdad();
		} else {
			return this.getNombre().compareTo(o.getNombre());
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nif == null) ? 0 : nif.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (id != other.id)
			return false;
		if (nif == null) {
			if (other.nif != null)
				return false;
		} else if (!nif.equals(other.nif))
			return false;
		return true;
	}
	
	
	
	
}
