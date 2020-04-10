package competicion;

import java.util.Collection;

import personal.Entrenador;
import personal.Jugador;

public interface Equipable extends Competicionable{
	
	int getIdentificador();
	Collection<Entrenador> getEntrenadores();
	Collection<Jugador> getJugadores();
	boolean tieneEntrenador();
	boolean tieneJugadores();
	void agregarEntrenador(Entrenador entrenador);
	void eliminarEntrenador(Entrenador entrenador);
	void agregarJugador(Jugador jugador);
	void eliminarJugador(Jugador jugador);
	void agregarJugadores(Collection<Jugador> jugadores);

}
