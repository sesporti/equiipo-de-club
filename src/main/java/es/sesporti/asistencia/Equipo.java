package es.sesporti.asistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import competicion.Categoria;
import competicion.Licencia;

public class Equipo implements Nombrable, EntrenadorEquipo, Comparable<Equipo>{

	protected long id;
	private String nombre;
	private Categoria categoria;
	private Licencia licencia;
	
	@OneToMany(targetEntity=Jugador.class)
	private List<Jugador> jugadores;
	
	@ManyToMany(targetEntity=Entrenador.class)	
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

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Licencia getLicencia() {
		return licencia;
	}

	public void setLicencia(Licencia licencia) {
		this.licencia = licencia;
	}

	public List<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(List<Jugador> jugadores) {
		this.jugadores = jugadores;
	}

	public List<Entrenador> getEntrenadores() {
		
		return entrenadores;
	}

	public void setEntrenadores(List<Entrenador> entrenadores) {
		if (this.entrenadores != null) {
			for (Entrenador entrenador : this.entrenadores) {
				entrenador.removeEquipo(this);
			}
		}	
		this.entrenadores = entrenadores;
	}
	
	public List<String> getNombreJugadores() {
		List<String> nombres = new ArrayList<>();
		for (Jugador jugador : getJugadores()) {
			nombres.add(jugador.getNombre());
		}
		return nombres;
	}
	
	public List<String> getNombreEntrenadores() {
		List<String> nombres = new ArrayList<>();
		for (Entrenador entrenador : getEntrenadores()) {
			nombres.add(entrenador.getNombre());
		}
		return nombres;
	}	

	//CONSTRUCTORS
	public Equipo() {
		setJugadores(new ArrayList<>());
		setEntrenadores(new ArrayList<>());
	}
	
	public Equipo(long id, String nombre, Categoria categoria, Licencia licencia) {
		this();
		setId(id);
		setNombre(nombre);
		setCategoria(categoria);
		setLicencia(licencia);

	}
	
	//METHODS
	
	/**
	 * Agrega un entrenador a un equipo, pero previamente el entrenador tiene que tener la licencia para poder entrenar un equipo con dicha licencia.
	 * @param entrenador
	 */
	public void addEntrenador(Entrenador entrenador) {
		if (!getEntrenadores().contains(entrenador)) {
			getEntrenadores().add(entrenador);
			if (!entrenador.getEquipos().contains(this)) {
			entrenador.getEquipos().add(this);
			}
		}	
	}	

	/**
	 * Agrega el jugador al equipo si no está en él, así como actualiza el equipo en el jugador pasado como parámetro.
	 * @param jugador
	 */
	public void addJugador(Jugador jugador){
	    if (!getJugadores().contains(jugador)) {
	    	getJugadores().add(jugador);
	    	if (jugador.getEquipo() != this) {
				jugador.setEquipo(this);
			}
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
	}
	
	public void removeJugador(Jugador jugador) {
		getJugadores().remove(jugador);
		
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
