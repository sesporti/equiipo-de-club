package es.sesporti.asistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

//import javax.persistence.OneToMany;

public class Equipo implements Nombrable, Comparable<Equipo>{

	protected long id;
	private String nombre;
	private String categoria;
	private String licencia;
	private List<Jugador> jugadores;
	private List<Entrenador> entrenadores;

	//ACCESORES
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

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getLicencia() {
		return licencia;
	}

	public void setLicencia(String licencia) {
		this.licencia = licencia;
	}

//	@OneToMany(targetEntity=Jugador.class)
	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


//	@OneToMany(targetEntity=Entrenador.class)
	public List<Entrenador> getEntrenadores() {
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}

	//CONSTRUCTORS
	public Equipo() {}
	
	public Equipo(long id, String nombre, String categoria, String licencia) {
		setId(id);
		setNombre(nombre);
		setCategoria(categoria);
		setLicencia(licencia);
		setJugadores(new ArrayList<>());
		setEntrenadores(new ArrayList<>());
	}
	
	//METHODS
	/**
	 * Agrega un entrenador a un equipo, pero previamente el entrenador tiene que tener la licencia para poder entrenar un equipo con dicha licencia.
	 * @param entrenador
	 */
	public void addEntrenador(Entrenador entrenador) {
		if (entrenador.getLicencias().contains(getLicencia()) && ! getEntrenadores().contains(entrenador)) {
			getEntrenadores().add(entrenador);
		    entrenador.getEquipos().add(this);
		}
	}
	
	/**
	 * Agrega el jugador al equipo si no está en él, así como actualiza el equipo en el jugador pasado como parámetro.
	 * @param jugador
	 */
	public void addJugador(Jugador jugador){
	    if (!getJugadores().contains(jugador)) {
	    	getJugadores().add(jugador);
		    jugador.setEquipo(this);	
		}	
	}
	
	public void addAllEntrenadores(Collection<Entrenador> entrenadores) {
		for (Entrenador entrenador : entrenadores) {
			addEntrenador(entrenador);
		}		
	}
	
	public void addAllJugadores(Collection<Jugador> jugadores) {
		for (Jugador jugador : jugadores) {
			addJugador(jugador);
		}				
	}
	
	public void removeEntrenador (Entrenador entrenador) {
		getEntrenadores().remove(entrenador);
		entrenador.getEquipos().remove(this);
	}
	
	public void removeJugador(Jugador jugador) {
		getJugadores().remove(jugador);
		jugador.setEquipo(null);
		
	}
	
	public void removeAllEntrenadores(Collection<Entrenador> entrenadores) {
		for (Entrenador entrenador : entrenadores) {
			removeEntrenador(entrenador);
		}				
	}
	
	public void removeAllJugadores(Collection<Jugador> jugadores) {
		for (Jugador jugador : jugadores) {
			removeJugador(jugador);
		}				
	}
	
	public boolean hasJugador(Jugador jugador) {
		return getJugadores().contains(jugador);
	}
	
	public boolean hasEntrenador(Entrenador entrenador) {
		return getEntrenadores().contains(entrenador);
	}
	
	public boolean hasAllJugadores(Collection<Jugador> jugadores) {
		return getJugadores().containsAll(jugadores);
	}
	
	public boolean hasAllEntrenadores(Collection<Entrenador> entrenadores) {
		return getEntrenadores().addAll(entrenadores);
	}
	
	@Override
	public String toString() {
		return String.format("Equipo (%s): Nombre: %s, Categoria: %s-%s, Plantilla: %s, Tecnicos: %s",
				getId(), getNombre(), getCategoria(), getLicencia(), getJugadores(), getEntrenadores());
	}

	@Override
	public int compareTo(Equipo o) {
		if (Nombrable.getComparadorPorNombre().compare(this, o) == 0) {
			return this.getCategoria().compareTo(o.getCategoria());
		}
		return Nombrable.getComparadorPorNombre().compare(this, o);
	}
		
}
