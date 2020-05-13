package es.sesporti.asistencia;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import competicion.Categoria;
import competicion.Licencia;

public class Jugador implements Nombrable, Comparable<Jugador>{

	protected long id;
	private String nombre, nif, poc;
	private LocalDate fechaNacimiento;
	
	@ManyToOne(targetEntity=Equipo.class)
	private Equipo equipo;
	
	@OneToMany(targetEntity=Asistencia.class)
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
		//Esta comprobación se realiza por la relacion de bidireccionalidad con equipo, hay que asegurarse
		//que al anterior equipo se le elimina el jugador de su lista antes de asignarselo al nuevo equipo.
		if (this.equipo != null) {
			this.equipo.removeJugador(this);
		}
		this.equipo = equipo;
	}
	
	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	
	}
	
	public long getIdEquipo() {
		return getEquipo().getId();
	}

	public void setIdEquipo(Long idEquipo) {
		getEquipo().setId(idEquipo);;
	}
	
	public String getNombreEquipo() {
		return getEquipo().getNombre();
	}
	
	public void setNombreEquipo(String nombre) {
		getEquipo().setNombre(nombre);
	}
	
	public Categoria getCategoriaEquipo() {
		return getEquipo().getCategoria();
	}
	
	public void setCategoriaEquipo(Categoria categoria) {
		getEquipo().setCategoria(categoria);
	}
	
	public Licencia getLicenciaEquipo() {
		return getEquipo().getLicencia();
	}
	
	public void setLicenciaEquipo(Licencia licencia) {
		getEquipo().setLicencia(licencia);
	}

	//CONSTRUCTORS
	public Jugador() {
		asistencias = new ArrayList<Asistencia>();
	}
	
	public Jugador(long id, String nif, LocalDate fechaNacimiento) {
		this(id, nif, fechaNacimiento, null);
	}
	
	public Jugador(long id, String nif, LocalDate fechaNacimiento, Equipo equipo) {
		this(id, "PENDIENTE DEFINICION", nif, "", fechaNacimiento, equipo);
		int edad = getEdad();
		String msjPoc = (edad > 17)? "MAYOR DE EDAD": "PENDIENTE DE DEFINICION";
		setPoc(msjPoc);
	}
	
	public Jugador (long id, String nombre, String nif, String poc, LocalDate fechaNacimiento, Equipo equipo) {
		this();
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setPoc(poc);
		setFechaNacimiento(fechaNacimiento);
		setEquipo(equipo);		
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
	 * Se utiliza para dar bidireccionalidad a la relacion @OneToMany-@ManyToOne.
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
	
	/**
	 * Elimina la asistencia al jugador si existe.
	 * @param asistencia
	 */
	public void removeAsistencia(Asistencia asistencia) { 
		getAsistencias().remove(asistencia);
	}
	
	@Override
	public String toString() {
		return String.format("Jugador (%s): Nombre: %s, NIF (%s), edad: %s, Persona de Contacto: %s, Equipo: %s ",
							getId(), getNombre(), getNif(), getEdad(), getPoc(), getNombreEquipo());				
	}

	/**
	 * Compara por {@code nombre} y si son equals compara por {@code fechaNacimiento}. 
	 */
	@Override
	public int compareTo(Jugador o) {
		
		if (Nombrable.getComparadorPorNombre().compare(this, o) == 0) {
			return this.getFechaNacimiento().compareTo(o.getFechaNacimiento());
		} else {
			return Nombrable.getComparadorPorNombre().compare(this, o);
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

	/**
	 * Dos jugadores se consideran equals si tiene el mismo {@code id} y {@code nif}.
	 * 
	 */
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
