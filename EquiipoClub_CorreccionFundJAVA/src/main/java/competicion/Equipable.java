package competicion;

import java.util.Collection;

import personal.Entrenador;
import personal.Jugador;

public interface Equipable extends Competicionable{
	
	int getIdentificador();
	Collection<Entrenador> getEntrenadores();
	Collection<Jugador> getJugadores();
	// Esto que sea calculado y default
	boolean tieneEntrenador();
	// Esto tambien
	boolean tieneJugadores();
	// Esto tambien puede ser default: getEntrenadores().add(entrenador);
	void agregarEntrenador(Entrenador entrenador);
	// Igual con remove
	void eliminarEntrenador(Entrenador entrenador);
	// Igual que con entrenador
	void agregarJugador(Jugador jugador);
	// Idem
	void eliminarJugador(Jugador jugador);
	// Idem
	void agregarJugadores(Collection<Jugador> jugadores);
	// Total que menos los tres primeros metodos el resto pueden tener
	// una implementacion por defecto
}
