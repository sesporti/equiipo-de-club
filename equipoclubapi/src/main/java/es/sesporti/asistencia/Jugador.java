package es.sesporti.asistencia;

import java.util.ArrayList;
import java.util.List;

//import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Jugador implements Identificable, Comparable<Jugador>{

	protected Long id;
	private String nombre, nif, poc;
	private int edad;
	
	@ManyToOne
//	@JoinColumn(name="ID_EQUIPO", referencedColumnName="ID")
	private Equipo equipo;
	
	@OneToMany(targetEntity=Asistencia.class)
	private List<Asistencia> asistencias;
	
	public Jugador() {}
	
	public Jugador(Long id, String nif, int edad) {
		this(id, "", nif, "", edad);
	}
	
	public Jugador (Long id, String nombre, String nif, String poc, int edad) {
		setId(id);
		setNombre(nombre);
		setNif(nif);
		setPoc(poc);
		setEdad(edad);
		asistencias = new ArrayList<Asistencia>();
	}
	
	public List<Asistencia> getAsistencias() {
		return asistencias;
	}

	public void setAsistencias(List<Asistencia> asistencias) {
		this.asistencias = asistencias;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	
	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}
	
	public Long getIdEquipo() {
		return getEquipo().getId();
	}

	public void setIdEquipo(Equipo equipo) {
		this.equipo.id = equipo.id;
	}
	
	public String getNombreEquipo() {
		return getEquipo().getNombre();
	}
	
	public String getCategoriaEquipo() {
		return getEquipo().getCategoria();
	}
	
	public void addAsistencia(Asistencia asistencia) {
        this.asistencias.add(asistencia);
        if (asistencia.getJugador() != this) {
            asistencia.setJugador(this);
        }
    }

	@Override
	public String toString() {
		return "Jugador [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getNif()=" + getNif() + ", getPoc()="
				+ getPoc() + ", getEdad()=" + getEdad() + "]";
	}

	@Override
	public int compareTo(Jugador o) {
		
		if (this.getNombre().equals(o.getNombre())) {
			return this.getEdad() - o.getEdad();
		} else {
			return this.getNombre().compareTo(o.getNombre());
		}
	}
	
	
}
