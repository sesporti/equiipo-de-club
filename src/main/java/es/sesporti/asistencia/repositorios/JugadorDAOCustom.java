package es.sesporti.asistencia.repositorios;

import java.util.List;

import es.sesporti.asistencia.Jugador;

public interface JugadorDAOCustom {
	
	List<Jugador> getJugadoresPorEdadesLicencia(int edadMinima, int edadMaxima);
	List<Jugador> getJugadoresPorEdad(int edadJugador);

}
