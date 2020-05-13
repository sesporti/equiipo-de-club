package es.sesporti.asistencia.repositorios;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import competicion.Licencia;
import es.sesporti.asistencia.Entrenador;
import es.sesporti.asistencia.Equipo;
import es.sesporti.asistencia.Jugador;

@Component
public class EquipoListener {
	
	private Logger log = LoggerFactory.getLogger(EquipoListener.class);
	
	private static EntrenadorDAO entrenadorDAO;
	
	private static JugadorDAO jugadorDAO;
	
	@Autowired
	public void init(EntrenadorDAO entrenadorDAO, JugadorDAO jugadorDAO) {
		EquipoListener.entrenadorDAO = entrenadorDAO;
		EquipoListener.jugadorDAO = jugadorDAO;
	}
	
	public void antesDeGuardar(Equipo equipo) {
		List<Jugador> jugadores = equipo.getJugadores();
		List<Entrenador> entrenadores = equipo.getEntrenadores();
		
		log.debug("ID equipo " + equipo.getId());

		//Validación de entrenadores
		if (entrenadores != null) {
			for (Entrenador entrenador : entrenadores) {
				if (!equipo.isEntrenadorValidoParaEquipo(entrenador, equipo)) {
					log.debug("@PrePersist => Entrenador {} ({}) no es válido para Equipo {}",
							entrenador.getNombre(), entrenador.getLicencias(), equipo.getNombre());
					equipo.getEntrenadores().remove(entrenador);
				} else {
					log.debug("@PrePersist => Entrenador {} ({}) VALIDO para Equipo {}",
							
							entrenador.getNombre(), entrenador.getLicencias(), equipo.getNombre());
				}
			}
		} else {
			log.trace("@PrePersist => Equipo {} NO tiene entrenadores asignados", equipo.getNombre());
			
			equipo.setEntrenadores(new ArrayList<Entrenador>());
		}
		
		//Validación de jugadores
		if (jugadores != null) {
			int[] rangoEdades = Licencia.getEdadesLicencia(equipo.getLicencia());
			for (Jugador jugador : jugadores) {
				if (jugador.getEdad() > rangoEdades[1]) {
					log.debug("@PrePersist => Jugador {}, con {} años no puede jugar en el Equipo {}",
							jugador.getNombre(), jugador.getEdad(), equipo.getNombre());
					
					equipo.getJugadores().remove(jugador);
				} else {
					log.debug("@PrePersist => El jugador {} cumple la edad para el equipo {}", jugador.getNombre(), equipo.getNombre());
				}

			}
		} else {
			log.debug("@PrePersist => El Equipo {} no tiene jugadores asignados", equipo.getNombre());
		}
		
		
		
	}
	
	public void despuesDeGuardar(Equipo equipo) {
		List<Jugador> jugadores = equipo.getJugadores();
		System.out.println(jugadores);
		List<Entrenador> entrenadores = equipo.getEntrenadores();
		System.out.println(entrenadores);
		
		log.debug("ID equipo " + equipo.getId());

		//Validación de entrenadores
		if (entrenadores != null && !entrenadores.isEmpty()) {
			System.out.println("Entrenadores:" + entrenadores);
			for (Entrenador entrenador : entrenadores) {
				if (!equipo.isEntrenadorValidoParaEquipo(entrenador, equipo)) {
					log.debug("@PostPersist => Entrenador {} ({}) no es válido para Equipo {}",
							entrenador.getNombre(), entrenador.getLicencias(), equipo.getNombre());
					equipo.getEntrenadores().remove(entrenador);
				} else {
					log.debug("@PostPersist => Entrenador {} ({}) VALIDO para Equipo {}",
							
							entrenador.getNombre(), entrenador.getLicencias(), equipo.getNombre());
//					equipo.getEntrenadores().add(entrenador);
				}
			}
		} else {
			log.debug("@PostPersist => Equipo {} NO tiene entrenadores asignados", equipo.getNombre());
			
			equipo.setEntrenadores(new ArrayList<Entrenador>());
			System.out.println("Entrenadores @PostLoad " + equipo.getEntrenadores());
		}
		
		//Validación de jugadores
		if (jugadores != null && !jugadores.isEmpty()) {
			System.out.println("Jugadores:" + jugadores);
			int[] rangoEdades = Licencia.getEdadesLicencia(equipo.getLicencia());
			System.out.println(Arrays.toString(rangoEdades));
			for (Jugador jugador : jugadores) {
				if (jugador.getEdad() > rangoEdades[1]) {
					log.debug("@PostPersist => Jugador {}, con {} años no puede jugar en el Equipo {}",
							jugador.getNombre(), jugador.getEdad(), equipo.getNombre());
					
					equipo.getJugadores().remove(jugador);
				} else {
					log.debug("@PostPersist => El jugador {} cumple la edad para el equipo {}", jugador.getNombre(), equipo.getNombre());
//					equipo.getJugadores().add(jugador);
				}

			}
		} else {
			log.debug("@PostPersist => El Equipo {} No tiene jugadores asignados", equipo.getNombre());
			equipo.setJugadores(new ArrayList<Jugador>());
			System.out.println("Jugadores @PostLoad" + equipo.getJugadores());
		}
		
	}
	
	public void antesDeBorrar(Equipo equipo) {
		List<Jugador> jugadores = equipo.getJugadores();
		log.debug("@PreRemove => Jugadores: {}", jugadores);
		
		List<Entrenador> entrenadores = equipo.getEntrenadores();
		log.debug("@PreRemove => Entrenadores: {}", entrenadores);
		
		for (Entrenador entrenador : entrenadores) {
			log.debug("@PreRemove => Equipo {} eliminado a Entrenador {}", equipo.getNombre(), entrenador.getNombre()); 
			entrenadorDAO.getOne(entrenador.getId()).removeEquipo(equipo);
		}
		
		for (Jugador jugador : jugadores) {
			log.debug("@PreRemove => Equipo {} eliminado a Jugador {}", equipo.getNombre(), jugador.getNombre());
			jugadorDAO.getOne(jugador.getId()).setEquipo(null);
		}
	}

}
