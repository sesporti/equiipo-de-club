package es.sesporti.asistencia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.OneToMany;

//import javax.persistence.Entity;
//import javax.persistence.Id;


public class Equipo implements Identificable, Comparable<Equipo>{


	protected Long id;
	private String nombre;
	private String categoria;
	private List<Jugador> jugadores;
	private List<Entrenador> entrenadores;
	
	public Equipo() {}
	
	public Equipo(Long id, String nombre, String categoria) {
		setId(id);
		setNombre(nombre);
		setCategoria(categoria);
		setJugadores(new ArrayList<>());
		setEntrenadores(new ArrayList<>());
	}
	
	public void addEntrenador(Entrenador entrenador) {
	    this.agregarEntrenador(entrenador);
	    entrenador.setEquipo(this);
	}
	
	public void addJugador(Jugador jugador){
	    this.agregarJugador(jugador);
	    jugador.setEquipo(this);
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return id;
	}

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

	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean agregarEntrenador (Entrenador entrenador) {
		
		return getEntrenadores().add(entrenador);
	}
	
	public boolean agregarJugador(Jugador jugador) {
		
		return getJugadores().add(jugador);
	}
	
	public boolean agregarEntrenadores(Collection<Entrenador> entrenadores) {
		return getEntrenadores().addAll(entrenadores);				
	}
	
	public boolean agregarJugadores(Collection<Jugador> jugadores) {
		return getJugadores().addAll(jugadores);				
	}
	
	public boolean eliminarEntrenador (Entrenador entrenador) {
		
		return getEntrenadores().remove(entrenador);
	}
	
	public boolean eliminarJugador(Jugador jugador) {
		
		return getJugadores().remove(jugador);
	}
	
	public boolean eliminarEntrenadores(Collection<Entrenador> entrenadores) {
		return getEntrenadores().removeAll(entrenadores);				
	}
	
	public boolean eliminarJugadores(Collection<Jugador> jugadores) {
		return getJugadores().removeAll(jugadores);				
	}
	
	public boolean tieneJugador(Jugador jugador) {
		return getJugadores().contains(jugador);
	}
	
	public boolean tieneEntrenador(Entrenador entrenador) {
		return getEntrenadores().contains(entrenador);
	}
	
	public String mostrarJugadores() {
		return getJugadores().toString();
	}
	
	public String mostrarEntrenadores() {
		return getEntrenadores().toString();
	}

	
	@Override
	public String toString() {
		return "Equipo [getId()=" + getId() + ", getNombre()=" + getNombre() + ", getCategoria()=" + getCategoria()
				+ ", getJugadores()=" + getJugadores() + ", getEntrenadores()=" + getEntrenadores() + "]";
	}

	@Override
	public int compareTo(Equipo o) {
		if (this.getNombre().equals(o.getNombre())) {
			return this.getCategoria().compareTo(o.getCategoria());
		} else {
			return this.getNombre().compareTo(o.getNombre());
		}
	}
	
}
