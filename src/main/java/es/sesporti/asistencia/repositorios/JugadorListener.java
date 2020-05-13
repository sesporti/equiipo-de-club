package es.sesporti.asistencia.repositorios;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import competicion.Licencia;
import es.sesporti.asistencia.Jugador;

@Component
public class JugadorListener {
	
	private Logger log = LoggerFactory.getLogger(JugadorListener.class);
	
	private static AsistenciaDAO asistenciaDAO;
	
	private static EquipoDAO equipoDAO;
	
	@Autowired
	public void init(AsistenciaDAO asistenciaDAO, EquipoDAO equipoDAO) {
		JugadorListener.asistenciaDAO = asistenciaDAO;
		JugadorListener.equipoDAO = equipoDAO;
	}
	
	public void antesDeGuardar(Jugador jugador) {//NO FUNCIONA ESTA VALIDACION ANTES DE PERSISTIR EL JUGADOR?????		
		if (jugador.getEquipo() != null) {
			Licencia licencia = jugador.getEquipo().getLicencia();
			int[] rangoEdades = Licencia.getEdadesLicencia(licencia);
			if (jugador.getEdad() > rangoEdades[1]) {
				log.debug("@PrePersist => El equipo {} no puede ser asignado al jugador {},"
						+ " su edad {} NO LO PERMITE {}", jugador.getEquipo(),
						jugador.getNombre(), jugador.getEdad(), Arrays.toString(rangoEdades));
				jugador.setEquipo(null);			
			} else {
				log.debug("El jugador {} cumple la edad para el equipo {}", jugador.getNombre(), jugador.getEquipo());
			}
		} else {
			log.debug("El jugador {} no tiene equipo asignado", jugador.getNombre());
		}
		
		
	}
	
	public void despuesDeGuardar(Jugador jugador) {
		if (jugador.getEquipo() != null) {
			Licencia licencia = jugador.getEquipo().getLicencia();
			int[] rangoEdades = Licencia.getEdadesLicencia(licencia);
			if (jugador.getEdad() > rangoEdades[1]) {
				System.out.println(Arrays.toString(rangoEdades));
				System.out.println(jugador.getEdad());
				log.debug("@PostPersist => El equipo {} no puede ser asignado al jugador {},"
						+ " su edad {} NO LO PERMITE {}", jugador.getEquipo().getNombre(),
						jugador.getNombre(), jugador.getEdad(), Arrays.toString(rangoEdades));
//				equipoDAO.getOne(jugador.getEquipo().getId()).removeJugador(jugador);
				jugador.setEquipo(null);			
			} else {
				System.out.println(Arrays.toString(rangoEdades));
				System.out.println(jugador.getEdad());
				log.debug("@PostPersist => El jugador {} cumple la edad para el equipo {}", jugador.getNombre(), jugador.getEquipo().getNombre());
			}
		} else {
			log.debug("@PostPersist => El jugador {} no tiene equipo asignado", jugador.getNombre());
		}
		
//		ESTO NO SERÍA NECESARIO, LA BIDIRECCIONALIDAD SE ENCUENTRA EN EL CODIGO DE LA CLASE JUGADOR Y EQUIPO
//		log.debug("@PostPersist Jugador {} agregado a Equipo {}", jugador.getNombre(), jugador.getEquipo().getNombre());
//		equipoDAO.getOne(jugador.getEquipo().getId()).addJugador(jugador);
	}
	
	public void antesDeBorrar (Jugador jugador) {
		log.debug("@PreRemove Jugador: borrando " + jugador.getAsistencias().size() + " asistencias");
		jugador.getAsistencias().forEach(a -> asistenciaDAO.delete(a));
		log.debug("@PreRemove Jugador {} borrado del Equipo {}", jugador.getNombre(), jugador.getEquipo().getNombre());
		equipoDAO.getOne(jugador.getEquipo().getId()).removeJugador(jugador);
	}
}
